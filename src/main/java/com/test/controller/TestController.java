package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: wuwei
 * @date: 2018/4/12 9:15
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final String LOGIN_MSG = "[tomcat port: %d] Welcome, %s!";
    private static final String LOGOUT_MSG = "[tomcat port: %d] Bye bye, %s!";
    private static Logger logger = Logger.getLogger(TestController.class.getName());

    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("name") String name) {
        request.getSession().setAttribute("name", name);
        String msg = String.format(LOGIN_MSG, request.getLocalPort(), name);
        logger.log(Level.INFO, msg);
        return msg;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String msg = String.format(LOGOUT_MSG, request.getLocalPort(), session.getAttribute("name"));
        session.invalidate();
        logger.log(Level.INFO, msg);
        return msg;
    }
}
