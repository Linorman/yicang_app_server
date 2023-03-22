package com.yicang_app.backend.controller;

import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.entity.user.UserInfo;
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
     * @param userInfo 用户信息
     * @return R
     */
    @RequestMapping("/login")
    public R login(UserInfo userInfo){
        return userService.login(userInfo);
    }

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @return R
     */
    @RequestMapping("/register")
    public R register(UserInfo userInfo){
        return userService.register(userInfo);
    }

    /**
     * 用户修改密码
     * @param userInfo 用户信息
     * @return R
     */
    @RequestMapping("/changePassword")
    public R changePassword(UserInfo userInfo){
        return userService.changePassword(userInfo);
    }

    /**
     * 用户登出
     * @param userInfo 用户信息
     * @return R
     */
    @RequestMapping("/logout")
    public R logout(UserInfo userInfo){
        return userService.logout(userInfo);
    }
}
