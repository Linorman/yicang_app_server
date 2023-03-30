package com.yicang_app.backend.mapper.userInterest;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yicang_app.backend.entity.collection.PaintingModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInterestPaintingMapper extends BaseMapper<PaintingModel> {
    @Select("SELECT * FROM ${tableName}")
    List<PaintingModel> selectUserInterestPainting(@Param("tableName") String tableName);
}
