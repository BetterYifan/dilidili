package com.dilidili.filter.service.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hit {
    private int level;

    private Object v;

    private int[] pos;
}
