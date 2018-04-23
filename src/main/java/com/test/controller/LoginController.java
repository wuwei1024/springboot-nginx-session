package com.test.controller;

import com.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wuwei
 * @date: 2018/4/12 9:15
 */
@RestController
@RequestMapping("/test")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("name") String name) {
        return loginService.login(request, name);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        return loginService.logout(request);
    }
}
