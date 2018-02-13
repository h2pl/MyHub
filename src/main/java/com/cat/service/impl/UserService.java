package com.cat.service.impl;

import com.cat.dao.IUserDao;
import com.cat.dao.common.IOperations;
import com.cat.model.User;
import com.cat.service.IUserService;
import com.cat.service.common.AbstractService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by 周杰伦 on 2018/1/12.
 */

@Service("userService")
public class UserService extends AbstractService<User>implements IUserService {

    private static final Logger logger = Logger.getLogger(UserService.class);

    @Resource(name = "userDao")
    private IUserDao userDao;

    @Override
    protected IOperations<User> getDao() {
        return userDao;
    }
}
