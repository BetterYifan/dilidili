package com.dilidili.filter.service.entity;

import com.dilidili.filter.service.entity.bo.AreaBO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatternFilterReq {
    private AreaBO areaBO;

    private String text;
}
