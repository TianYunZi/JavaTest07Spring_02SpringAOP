package org.aop.test002springmvc.action;

import org.aop.test002springmvc.Model.User;
import org.aop.test002springmvc.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by Admin on 2017/5/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Log LOG = LogFactory.getLog(UserController.class);

    private UserService userService;

    private ExecutorService executorService;

    @Autowired
    public UserController(UserService userService, ExecutorService executorService) {
        this.userService = userService;
        this.executorService = executorService;
    }

    @RequestMapping("/add.do")
    public String user(final ModelMap modelMap) {
        userService.add("新用户");
        Future<String> future = executorService.submit(() -> {
            modelMap.addAttribute("username", "新用户");
            System.out.println("新用户");
            return "user";
        });
        try {
            LOG.info("--新用户--");
            return future.get();
        } catch (InterruptedException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        } catch (ExecutionException e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        }

        return "index";
    }
}
