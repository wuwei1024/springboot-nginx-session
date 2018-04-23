package com.test.serviceImpl;

import com.test.service.LoginService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: wuwei
 * @date: 2018/4/23 15:11
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final String LOGIN_MSG = "[tomcat port: %d] Welcome, %s!";
    private static final String LOGOUT_MSG = "[tomcat port: %d] Bye bye, %s!";
    private static Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());

    @Override
    public String login(HttpServletRequest request, String name) {
        request.getSession().setAttribute("name", name);
        String msg = String.format(LOGIN_MSG, request.getLocalPort(), name);
        logger.log(Level.INFO, msg);
        return msg;
    }

    @Override
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String msg = String.format(LOGOUT_MSG, request.getLocalPort(), session.getAttribute("name"));
        session.invalidate();
        logger.log(Level.INFO, msg);
        return msg;
    }
}
