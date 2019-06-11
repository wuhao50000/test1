package com.itheima.controller;

import com.itheima.bean.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUserById")
    public void getUserById(Integer id){
        System.out.println(id);
        System.out.println("进入UserController");
        User user = userService.getUserById(id);
        System.out.println(user);
    }


}
