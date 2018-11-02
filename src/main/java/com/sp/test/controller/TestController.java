package com.sp.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: zhangzhipeng
 * @Date: 2018/7/29 16:58
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
