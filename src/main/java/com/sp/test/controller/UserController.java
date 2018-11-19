package com.sp.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.sp.test.domain.User;
import com.sp.test.service.UserService;
import com.sp.test.util.Imageutil;
import com.sp.test.util.MD5Util;
import com.sp.test.util.SendMai;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * @Auther: cfy
 * @Date: 2018年11月1日15:26:51
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/User")
public class UserController {
    private static Logger logger =Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String findUserList(Model model){
        List<User> userList = userService.findUserList();
        model.addAttribute("userList", userList);
        return "/user/user_list";
    }


    @RequestMapping("/deleteUser")
    @ResponseBody
    public JSONObject deleteUser(Long id){
        JSONObject object = new JSONObject();
        int result =userService.deleteUser(id);
        object.put("isOkk",result);
        return object;


    }



    @RequestMapping(value = "login")
    public String Login(HttpServletRequest request,@Param("username") String userName,@Param("password")String password,@Param("regcode") String regcode) {
        String code =request.getParameter("regcode");
        logger.info(code);
        HttpSession session = request.getSession();
      String imagecode = (String) session.getAttribute("imageCode");
        logger.info(imagecode);
        User re= userService.selectByUser(userName);
        System.out.println(code+"hello world"+imagecode);
        if(userName.equals(re.getUserName()) && userName!=null && !("").equals(userName))
                if (password.equals(re.getPassword()) && password!=null){
                        return "/user/success";
                }


        return "/user/fail";
    }


    //生成验证码图片
    @RequestMapping(value = "/valicode")
    //对应/user/valicode.do请求
    public void valicode(HttpServletResponse response, HttpSession session) throws Exception{
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = Imageutil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode",objs[0]);
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);


    }
    @RequestMapping(value="/register",method ={RequestMethod.GET,RequestMethod.POST})
    public  String register(HttpServletRequest request,HttpServletResponse response,User user,Model model){
        String email = request.getParameter("email");
        System.out.println(email);
        user.setValidateCode(MD5Util.encode2hex(email));
        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/User/ValEmail?email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(user.getValidateCode());
        sb.append("\">http://localhost:8080/User/ValEmail?email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(user.getValidateCode());
        sb.append("</a>");
        SendMai.send(email,sb.toString());
        System.out.println("成功发送邮件");
        int result =userService.insert(user);
       if(result>0){
           model.addAttribute("msg","已经成功发送邮件");
           logger.info("已经成功发送邮件");
           return "/user/success";
       }else {
           model.addAttribute("msg","注册失败");
           logger.info("注册失败");
           return "/user/fail";
       }
    }
    @RequestMapping(value="/ValEmail" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String toValEmail(HttpServletRequest request,HttpServletResponse response, Model model) {
        String email = request.getParameter("email");
        String validateCode = request.getParameter("validateCode");
        User user = userService.selectByEmail(email);
        if (user == null) {
            model.addAttribute("msg", "无此用户");
            logger.info("没有此用户");
            return "/user/success";
        } else {
            if (user.getValidateCode().equals(validateCode)) {
                if (user.getStatus() == 0) {
                    user.setStatus(1);
                    userService.updateUserSts(user);
                    model.addAttribute("msg", "激活成功");
                    return "/user/success";
                } else {
                    model.addAttribute("msg", "已经失效，请勿重复点击");
                    return "/user/fail";
                }

            } else {
                return "/user/fail";
            }
        }
    }
       @RequestMapping("/checkUserName")
       @ResponseBody
        public JSONObject checkUserName (String username){
            JSONObject object = new JSONObject();
            User result = userService.selectByUser(username);
            if (result==null) {
                object.put("isok", 0);
            }else {
                object.put("isok",1);
            }
            //如果result>0则更新成功，result=0则没数据或更新失败
            return object;
        }




}
