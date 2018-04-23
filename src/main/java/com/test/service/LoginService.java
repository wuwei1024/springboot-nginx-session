package com.test.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wuwei
 * @date: 2018/4/23 15:08
 */

public interface LoginService {
    String login(HttpServletRequest request, String name);

    String logout(HttpServletRequest request);
}
