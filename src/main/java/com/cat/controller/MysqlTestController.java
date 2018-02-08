package com.cat.controller;

import com.cat.entity.CommonResponseEntity;
import com.cat.model.User;
import com.cat.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 周杰伦 on 2018/2/8.
 */
@Controller
@RequestMapping("mysql/")
public class MysqlTestController {

    private static final Logger logger = Logger.getLogger(MysqlTestController.class);

    @Resource(name = "userService")
    IUserService userService;

    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CommonResponseEntity ceateUser(User user){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        user.setUserName(user.getUserName());
        user.setPassWord(user.getPassWord());
        userService.create(user);
        commonResponseEntity.setRetData(user);
        logger.info("ok");
        return commonResponseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.DELETE)
    public String deleteUser(){
        return "mysql";
    }

    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.PUT)
    public String editUser(){
        return "mysql";
    }

    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String getUser(){
        return "mysql";
    }
}
