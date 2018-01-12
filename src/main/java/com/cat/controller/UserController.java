package com.cat.controller;

import com.cat.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 周杰伦 on 2018/1/12.
 */
@Controller
public class UserController {
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(){
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        User user = new User();
        
        return "test";
    }
}
