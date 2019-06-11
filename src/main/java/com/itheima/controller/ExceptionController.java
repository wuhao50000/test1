package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("excep1")
    public String excep1() {
        System.out.println("excep1");
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        return "/login.html";
    }


}
