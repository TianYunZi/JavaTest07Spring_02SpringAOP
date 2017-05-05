package org.aop.test002springmvc.dao;

import org.aop.test002springmvc.Model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 2017/5/4.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private static final Log LOG = LogFactory.getLog(UserDAOImpl.class);

    @Override
    public void add(User user) {
        LOG.info("UserDAO.add(): " + user);
    }
}
