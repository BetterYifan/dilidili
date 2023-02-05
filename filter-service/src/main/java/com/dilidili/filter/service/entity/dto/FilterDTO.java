package com.dilidili.filter.service.entity.dto;

import lombok.Data;

@Data
public class FilterDTO {

    /**
     * 待过滤文本
     */
    private String text;

    /**
     * 业务方
     */
    private String area;
}
