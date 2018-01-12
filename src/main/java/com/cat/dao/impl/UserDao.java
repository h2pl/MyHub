package com.cat.dao.impl;

import com.cat.dao.IUserDao;
import com.cat.dao.common.AbstractHibernateDao;
import com.cat.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by 周杰伦 on 2018/1/12.
 */

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao{
}
