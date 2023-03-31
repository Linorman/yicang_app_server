package com.yicang_app.backend.mapper.userInterest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicang_app.backend.entity.collection.Novel;
import com.yicang_app.backend.entity.user.UserCollectionNovel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 用户关注小说Mapper
 * @author linorman
 * @data 2023/03/28
 */
@Mapper
public interface UserInterestNovelMapper extends BaseMapper<UserCollectionNovel> {
    @Select("SELECT * FROM ${tableName}")
    List<Novel> selectUserInterestNovel(@Param("tableName") String tableName);
}
