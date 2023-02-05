package com.dilidili.filter.service.service;

import com.dilidili.filter.service.entity.dto.FilterDTO;
import com.dilidili.filter.service.entity.vo.FilterVO;

import javax.servlet.http.HttpServletRequest;

public interface FilterService {
    FilterVO filter(FilterDTO filterDTO, HttpServletRequest request);
}
