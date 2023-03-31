package com.yicang_app.backend.controller;

import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.entity.user.UserInfo;
import com.yicang_app.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/login")
    public R login(UserInfo userInfo){
        return userService.login(userInfo);
    }

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @return R
     */
    @PostMapping("/register")
    public R register(UserInfo userInfo){
        return userService.register(userInfo);
    }

    /**
     * 用户修改密码
     * @param userInfo 用户信息
     * @return R
     */
    @PutMapping("/changePassword")
    public R changePassword(UserInfo userInfo){
        return userService.changePassword(userInfo);
    }

    /**
     * 用户登出
     * @param userInfo 用户信息
     * @return R
     */
    @PostMapping("/logout")
    public R logout(UserInfo userInfo){
        return userService.logout(userInfo);
    }

    /**
     * 获取用户小说藏品
     * @param userInfo 用户信息
     * @return R
     */
    @GetMapping("/collectionNovel")
    public R getUserCollectionNovel(UserInfo userInfo){
        return userService.getUserCollectionNovel(userInfo);
    }

    /**
     * 获取用户画作藏品
     * @param userInfo 用户信息
     * @return R
     */
    @GetMapping("/collectionPainting")
    public R getUserCollectionPainting(UserInfo userInfo) {
        return userService.getUserCollectionPainting(userInfo);
    }

    /**
     * 获取用户关注的小说列表
     * @param userInfo 用户信息
     * @return R
     */
    @GetMapping("/interestNovelList")
    public R getUserInterestNovelList(UserInfo userInfo) {
        return userService.getUserInterestNovelList(userInfo);
    }

    /**
     * 获取用户关注的画作列表
     * @param userInfo 用户信息
     * @return R
     */
    @GetMapping("/interestPaintingList")
    public R getUserInterestPaintingList(UserInfo userInfo) {
        return userService.getUserInterestPaintingList(userInfo);
    }
}
