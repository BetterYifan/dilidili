package com.dilidili.entity.POJO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "filter_white_area")
public class FilterWhiteAreaDO {
    private Long id;

    private String area;

    @TableField("content_id")
    private Long contentId;

    private Integer state;

    @TableField("tpid")
    private Integer tpId;

    private Date ctime;

    private Date mtime;
}
