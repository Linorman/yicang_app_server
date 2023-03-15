package com.yicang_app.backend.entity.User;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * 用户收藏小说模型
 * @author linorman
 * @data 2023/03/15
 */
@lombok.Data
public class UserCollectionNovel implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String boughtTime;
    private long id;
    private long novelId;
    private String novelName;
    @TableField(fill = FieldFill.INSERT)
    private String updateTime;
}