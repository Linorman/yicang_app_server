package com.yicang_app.backend.controller;

import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author linorman
 * @date 2023/03/13
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return R
     */
    @RequestMapping("/login")
    public R login(String username, String password) {
        return userService.login(username, password);
    }

}
