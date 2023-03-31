package com.yicang_app.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.entity.collection.NovelModel;
import com.yicang_app.backend.entity.user.UserCollectionNovel;
import com.yicang_app.backend.entity.user.UserCollectionPainting;
import com.yicang_app.backend.entity.user.UserInfo;

import java.util.List;

/**
 * User Service
 * @author linorman
 * @data 2023/03/13
 */
public interface UserService extends IService<UserInfo> {
    /**
     * 用户登录
     * @param user 用户信息
     * @return R
     */
    R login(UserInfo user);

    /**
     * 用户注册
     * @param user 用户信息
     * @return R
     */
    R register(UserInfo user);

    /**
     * 用户修改密码
     * @param user 用户信息
     * @return R
     */
    R changePassword(UserInfo user);

    /**
     * 用户登出
     * @param user 用户信息
     * @return R
     */
    R logout(UserInfo user);

    /**
     * 用户收藏小说
     * @param user 用户信息
     * @return R
     */
    R<List<UserCollectionNovel>> getUserCollectionNovel(UserInfo user);

    /**
     * 用户收藏画作
     * @param user 用户信息
     * @return R
     */
    R<List<UserCollectionPainting>> getUserCollectionPainting(UserInfo user);

    /**
     * 获取用户关注的小说
     * @param user 用户信息
     * @return R
     */
    R<List<NovelModel>> getUserInterestNovelList(UserInfo user);
}
