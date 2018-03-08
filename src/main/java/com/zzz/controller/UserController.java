package com.zzz.controller;

import com.zzz.model.vo.UserVo;
import com.zzz.service.UserService;
import com.zzz.support.ResponseEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCurrentUser")
    public ResponseEntity getCurrentUser(HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute("user");

        return ResponseEntity.ok(userVo);
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

    @PostMapping("/updatePassword")
    public ResponseEntity updatePassword(@RequestBody UserVo userVo) {
        userService.updatePassword(userVo);

        return ResponseEntity.ok();
    }

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findUserByPage")
    public ResponseEntity findAllByPage(String username, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        return ResponseEntity.ok(userService.findAll(userVo, pageable));
    }

    @GetMapping("/findByUsername")
    public ResponseEntity findByUsername(String username) {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserVo userVo) {
        userVo.setCreateTime(LocalDateTime.now());
        userVo.setUpdateTime(LocalDateTime.now());
        userVo.setStatus(1);

        userService.save(userVo);

        return ResponseEntity.ok();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(Integer id) {
        userService.delete(id);

        return ResponseEntity.ok();
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UserVo userVo) {
        userService.update(userVo);

        return ResponseEntity.ok();
    }

    @GetMapping("/findById")
    public ResponseEntity findById(Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
