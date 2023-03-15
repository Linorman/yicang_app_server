package com.yicang_app.backend.entity.User;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

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