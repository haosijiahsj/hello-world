package com.zzz.service;

import com.zzz.support.AuthContext;

import javax.servlet.http.HttpSession;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
public interface AuthService {

    void login(String username, String password);

    void logout();

    boolean authenticate(AuthContext authContext);

}
