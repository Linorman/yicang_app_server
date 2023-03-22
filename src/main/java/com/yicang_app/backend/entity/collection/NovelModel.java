package com.yicang_app.backend.entity.collection;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 小说模型
 * @author linorman
 * @data 2023/03/15
 */
@Data
public class NovelModel implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    private String filePath;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String finishTime;
    private long id;
    private String introduction;
    private String novelName;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
    private String writer;
}
