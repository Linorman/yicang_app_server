package com.yicang_app.backend.mapper.User;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicang_app.backend.entity.User.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户收藏绘画Mapper
 * @author linorman
 * @data 2023/03/19
 */
@Mapper
public interface UserCollectionPaintingMapper extends BaseMapper<UserInfo> {
}
