package com.dilidili.entity.BO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class FilterAreaContentBO {
    private Integer id;

    private String area;

    @TableField("filterid")
    private Integer filterId;

    private String filter;

    private Integer source;

    private Integer mode;

    private Integer isDelete;

    private Integer level;

    private Integer typeId;

    private Date ctime;

    private Date mtime;
}
