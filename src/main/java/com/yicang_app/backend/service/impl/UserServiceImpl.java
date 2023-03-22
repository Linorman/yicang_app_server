package com.yicang_app.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.constant.ResultCode;
import com.yicang_app.backend.entity.user.UserCollectionNovel;
import com.yicang_app.backend.entity.user.UserInfo;
import com.yicang_app.backend.mapper.user.user_collection_novel.UserCollectionNovelMapper;
import com.yicang_app.backend.mapper.user.user_collection_painting.UserCollectionPaintingMapper;
import com.yicang_app.backend.mapper.user.user_info.UserInfoMapper;
import com.yicang_app.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User Service Impl
 * @author linorman
 * @data 2023/03/13
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserService {
    @Autowired
    @Qualifier("userInfoMapper")
    private UserInfoMapper userMapper;

    @Autowired
    @Qualifier("userCollectionNovelMapper")
    private UserCollectionNovelMapper userCollectionNovelMapper;

    @Autowired
    @Qualifier("userCollectionPaintingMapper")
    private UserCollectionPaintingMapper userCollectionPaintingMapper;

    @Override
    public R login(UserInfo user) {
        String username = user.getUsername();
        String password = user.getPassword();
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

    @Override
    public R register(UserInfo userInfo) {
        String username = userInfo.getUsername();
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userMapper.selectOne(queryWrapper);
        if (temp != null) {
            log.info("用户已存在");
            return R.error(ResultCode.USER_EXISTS, null);
        }
        userInfo.setStatus(1);
        userMapper.insert(userInfo);
        log.info("用户注册成功");
        return R.success(ResultCode.USER_SUCCESS, null);

    }

    @Override
    public R changePassword(UserInfo userInfo) {
        String username = userInfo.getUsername();
        String password = userInfo.getPassword();
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo temp = userMapper.selectOne(queryWrapper);
        if (temp == null) {
            log.info("用户不存在");
            return R.error(ResultCode.USER_NOT_EXIST, null);
        }
        userMapper.updateById(userInfo);
        log.info("用户修改密码成功");
        return R.success(ResultCode.USER_SUCCESS, null);
    }

    @Override
    public R logout(UserInfo userInfo) {
        return null;
    }

    @Override
    public R<List<UserCollectionNovel>> getUserCollectionNovel(UserInfo userInfo) {
        String username = userInfo.getUsername();
        return null;
    }


}
