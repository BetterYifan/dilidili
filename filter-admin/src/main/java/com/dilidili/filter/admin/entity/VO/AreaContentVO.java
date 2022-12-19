package com.dilidili.filter.admin.entity.VO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AreaContentVO {
    private Long id;

    private String area;

    private Integer level;

    /**
     * 词条id
     */
    private Long filterid;

    /**
     * 敏感词内容
     */
    private String filter;

    private Date ctime;

    private Date mtime;
}
