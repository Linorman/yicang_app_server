package com.yicang_app.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.entity.collection.Novel;
import com.yicang_app.backend.entity.collection.Painting;
import com.yicang_app.backend.entity.user.UserInfo;

import java.util.List;

/**
 * 商城服务接口
 * @author linorman
 * @date 2023/03/30
 */
public interface MallService extends IService<UserInfo> {
    /**
     * 获取小说列表
     * @return R
     */
    R<List<Novel>> novelList();

    /**
     * 获取画作列表
     * @return R
     */
    R<List<Painting>> paintingList();
}
