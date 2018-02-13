package com.cat.dao.impl;

import com.cat.dao.IUserDao;
import com.cat.dao.common.AbstractHibernateDao;
import com.cat.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * Created by 周杰伦 on 2018/1/12.
 */

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao{

    private static final Logger logger = Logger.getLogger(UserDao.class);

    public UserDao() {
        super();
        setClazz(User.class);
    }
}
