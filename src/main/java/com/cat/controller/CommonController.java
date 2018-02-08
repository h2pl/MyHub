package com.cat.controller;

import com.cat.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 周杰伦 on 2018/2/8.
 */
@Controller
public class CommonController {

    @RequestMapping(value = "mysql", method = RequestMethod.GET)
    public String testMysql(){
        return "mysql";
    }

    @RequestMapping(value = "redis", method = RequestMethod.GET)
    public String testRedis(){
        return "redis";
    }

    @RequestMapping(value = "dubbo", method = RequestMethod.GET)
    public String testDubbo(){
        return "dubbo";
    }

    @RequestMapping(value = "mq", method = RequestMethod.GET)
    public String testMq(){
        return "mq";
    }
}
