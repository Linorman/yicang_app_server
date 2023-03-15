package com.yicang_app.backend.entity.User;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserCollectionPainting implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String boughtTime;
    private long id;
    private long paintingId;
    private String paintingName;
    @TableField(fill = FieldFill.INSERT)
    private String updateTime;
}