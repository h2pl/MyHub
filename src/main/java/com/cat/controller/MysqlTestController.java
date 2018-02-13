package com.cat.controller;

import com.cat.entity.CommonResponseEntity;
import com.cat.exception.HubException;
import com.cat.model.User;
import com.cat.service.IUserService;
import com.cat.util.ConstantUtil;
import com.cat.vo.user.RegisterRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public CommonResponseEntity createUser(@RequestBody RegisterRequest registerRequest){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        commonResponseEntity.setRetCode(ConstantUtil.RETCODE_ERROR);
        try {
            User user = new User();
            user.setUserName(registerRequest.getUserName());
            user.setPassWord(registerRequest.getPassWord());
            userService.create(user);
            commonResponseEntity.setRetData(user);
            commonResponseEntity.setRetCode(ConstantUtil.RETCODE_CORRECT);
        }catch (Exception e) {
            logger.error(e.getMessage());
            commonResponseEntity.setRetMsg(ConstantUtil.QUERY_MSG_ERROR + e.getMessage());
            return commonResponseEntity;
        }
        return commonResponseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public CommonResponseEntity deleteUser(@PathVariable("id") Integer id){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        commonResponseEntity.setRetCode(ConstantUtil.RETCODE_ERROR);
        try {
            userService.deleteByCondition("id", id);
            commonResponseEntity.setRetCode(ConstantUtil.RETCODE_CORRECT);
        }catch (Exception e) {
            logger.error(e.getMessage());
            commonResponseEntity.setRetMsg(ConstantUtil.QUERY_MSG_ERROR + e.getMessage());

            return commonResponseEntity;
        }

        return commonResponseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "edit", method = RequestMethod.PUT)
    public CommonResponseEntity editUser(@RequestBody User user){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        commonResponseEntity.setRetCode(ConstantUtil.RETCODE_ERROR);
        try {
            userService.update(user);
            commonResponseEntity.setRetData(user);
            commonResponseEntity.setRetCode(ConstantUtil.RETCODE_CORRECT);
        }catch (Exception e) {
            logger.error(e.getMessage());
            commonResponseEntity.setRetMsg(ConstantUtil.QUERY_MSG_ERROR + e.getMessage());
            return commonResponseEntity;
        }
        return commonResponseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public CommonResponseEntity getUser(@PathVariable("id") Integer id){
        CommonResponseEntity commonResponseEntity = new CommonResponseEntity();
        commonResponseEntity.setRetCode(ConstantUtil.RETCODE_ERROR);
        try {
            User user = userService.findOneById(id);
            commonResponseEntity.setRetData(user);
            commonResponseEntity.setRetCode(ConstantUtil.RETCODE_CORRECT);
        }catch (Exception e) {
            logger.error(e.getMessage());
            commonResponseEntity.setRetMsg(ConstantUtil.QUERY_MSG_ERROR + e.getMessage());
            return commonResponseEntity;
        }

        return commonResponseEntity;
    }
}
