package com.zzz.controller;

import com.zzz.exceptions.IncorrectCredentialsException;
import com.zzz.exceptions.UnknownAccountException;
import com.zzz.service.AuthService;
import com.zzz.support.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author hushengjun
 * @date 2018/3/8
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public ResponseEntity login(String username, String password) {
        try {
            authService.login(username, password);
        } catch (Exception ex) {
            if (ex instanceof UnknownAccountException) {
                return ResponseEntity.of(401, "用户不存在！");
            } else if (ex instanceof IncorrectCredentialsException) {
                return ResponseEntity.of(401, "密码错误！");
            }
        }
        return ResponseEntity.ok();
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        authService.logout();
        return ResponseEntity.ok();
    }

}
