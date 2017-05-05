package org.aop.test002springmvc.action;

import org.aop.test002springmvc.Model.User;
import org.aop.test002springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 2017/5/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/add.do")
    public String user(ModelMap modelMap) {
        modelMap.addAttribute("username", "新用户");
        userService.add("新用户");
        return "user";
    }
}
