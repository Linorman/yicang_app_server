package com.yicang_app.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.constant.ResultCode;
import com.yicang_app.backend.entity.User.UserInfo;
import com.yicang_app.backend.mapper.UserMapper;
import com.yicang_app.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service Impl
 * @author linorman
 * @data 2023/03/13
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public R login(String username, String password) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userMapper.selectOne(queryWrapper);
        log.info("temp:{}", temp);
        if (temp == null) {
            log.info("用户不存在");
            return R.error(ResultCode.USER_NOT_EXIST, null);
        }
        if (!password.equals(temp.getPassword())) {
            log.info("密码错误");
            return R.error(ResultCode.USER_PASSWORD_ERROR, null);
        }
        if (temp.getStatus() == 0) {
            log.info("用户已被禁用");
            return R.error(ResultCode.USER_ACCOUNT_LOCKED, null);
        }
        log.info("用户登陆成功{}", temp);
        return R.success(ResultCode.USER_SUCCESS, temp);
    }
}
