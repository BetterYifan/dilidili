package com.dilidili.filter.service.entity.api;

import com.dilidili.filter.service.entity.Hit;
import com.dilidili.filter.service.entity.bo.AreaBO;

import java.util.List;

/**
 *
 */
@FunctionalInterface
public interface Filter {
    List<Hit> filter(AreaBO area, String text);
}
