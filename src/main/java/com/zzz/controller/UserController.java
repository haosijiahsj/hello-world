package com.zzz.controller;

import com.zzz.model.vo.UserVo;
import com.zzz.service.UserService;
import com.zzz.support.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity login(HttpSession session, String username, String password) {
        UserVo userVo = userService.findByUsername(username);

        if (userVo == null) {
            return ResponseEntity.of(301, "用户不存在！");
        }
        if (!password.equals(userVo.getPassword())) {
            return ResponseEntity.of(301, "密码错误！");
        }

        session.setAttribute("user", userVo);

        return ResponseEntity.ok();
    }

    @PostMapping("/registry")
    public ResponseEntity registry(@RequestBody UserVo userVo) {
        UserVo oldUserVo = userService.findByUsername(userVo.getUsername());

        if (oldUserVo != null) {
            return ResponseEntity.of(301, "用户已经存在！");
        }
        userService.save(userVo);

        return ResponseEntity.ok();
    }

}
