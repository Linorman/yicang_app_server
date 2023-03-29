package com.yicang_app.backend.mapper.userInterest.impl;

import com.yicang_app.backend.entity.collection.NovelModel;
import com.yicang_app.backend.mapper.userInterest.UserInterestNovelMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInterestNovelMapperImpl implements UserInterestNovelMapper {
    private final UserInterestNovelMapper userInterestNovelMapper;
    @Autowired
    public UserInterestNovelMapperImpl(UserInterestNovelMapper userInterestNovelMapper) {
        this.userInterestNovelMapper = userInterestNovelMapper;
    }

    @Override
    public List<NovelModel> selectUserInterestNovel(@Param("tableName") String tableName) {

    }
}
