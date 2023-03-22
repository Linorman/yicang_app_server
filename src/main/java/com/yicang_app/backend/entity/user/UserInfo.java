package com.yicang_app.backend.entity.user;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户模型
 * @author linorman
 * @data 2023/03/13
 */
@Data
public class UserInfo implements Serializable{
    private Long id;
    private Long characterCode;
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    private String password;
    private String signature;
    private long status;
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
    private String username;
}
