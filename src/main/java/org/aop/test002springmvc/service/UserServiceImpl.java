package org.aop.test002springmvc.service;

import org.aop.test002springmvc.Model.User;
import org.aop.test002springmvc.dao.UserDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/5/4.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String add(String username) {
        LOG.info("UserService.add()");
        User user = new User(username);
        userDAO.add(user);
        return "Service返回值";
    }

    @Override
    public void delete() {
        LOG.warn(new NullPointerException().getMessage());
    }
}
