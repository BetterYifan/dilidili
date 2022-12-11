package com.dilidili.entity.POJO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "filter_area")
public class FilterAreaDO {

    private Integer id;

    private String area;

    @TableField("filterid")
    private Integer filterId;

    @TableField("is_delete")
    private Integer isDelete;

    private Integer level;

    @TableField("typeid")
    private Integer typeId;

    private Date ctime;

    private Date mtime;
}
