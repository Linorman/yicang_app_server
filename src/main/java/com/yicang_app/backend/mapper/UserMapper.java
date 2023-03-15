package com.yicang_app.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicang_app.backend.entity.User.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * User Mapper
 * @author linorman
 * @data 2023/03/13
 */
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {
}
