package com.cat.controller;

import com.cat.entity.CommonResponseEntity;
import com.cat.model.User;
import com.cat.service.IUserService;
import com.cat.vo.user.RegisterRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 周杰伦 on 2018/1/12.
 */
@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(){
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        User user = new User();
        
        return "test";
    }

    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public CommonResponseEntity register(RegisterRequest registerRequest){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassWord(registerRequest.getPassWord());
        userService.create(user);
        commonResponseEntity.setRetData(user);
        logger.info("ok");
        return commonResponseEntity;
    }
}
