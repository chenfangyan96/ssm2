package com.sp.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.sp.test.domain.User;
import com.sp.test.service.UserService;
import com.sp.test.util.Imageutil;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;

/**
 * @Auther: cfy
 * @Date: 2018年11月1日15:26:51
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
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

    /**
     * 更新用户状态
     * @param status
     * @param id
     * @return
     */
    @RequestMapping("/updateSts")
    @ResponseBody
    public JSONObject updateSts(String status,Long id){
        JSONObject object = new JSONObject();
        int result = userService.updateUserSts(id,status);
        object.put("isOk", result);//如果result>0则更新成功，result=0则没数据或更新失败
        return object;
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
    public String Login(@Param("username") String userName,@Param("password")String password) {
        User re= userService.selectByUser(userName);
        System.out.println("hello world");
        if(userName.equals(re.getUserName()) && userName!=null && !("").equals(userName))
                if (password.equals(re.getPassword()) && password!=null){
                        return "/user/sueccess";
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
}
