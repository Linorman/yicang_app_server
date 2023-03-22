package com.yicang_app.backend.entity.collection;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * 画作模型
 * @author linorman
 * @data 2023/03/15
 */
@Data
public class PaintingModel implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    private String filePath;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String finishTime;
    private long id;
    private String introduction;
    private String painter;
    private String paintingName;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
}
