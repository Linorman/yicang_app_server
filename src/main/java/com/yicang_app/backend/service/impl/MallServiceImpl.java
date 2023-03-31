package com.yicang_app.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yicang_app.backend.entity.user.UserInfo;
import com.yicang_app.backend.mapper.user.UserInfoMapper;
import com.yicang_app.backend.service.MallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 商城服务实现类
 * @author linorman
 * @date 2023/03/30
 */
@Slf4j
@Service
public class MallServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements MallService {

}
