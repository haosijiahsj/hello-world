package com.zzz.service;

import com.zzz.support.AuthContext;

import javax.servlet.http.HttpSession;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
public interface AuthService {

    void login(HttpSession session, String username, String password);

    void logout(HttpSession session);

    boolean authenticate(AuthContext authContext);

}
