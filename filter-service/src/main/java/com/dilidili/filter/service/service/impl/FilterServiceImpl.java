package com.dilidili.filter.service.service.impl;

import com.dilidili.filter.service.entity.bo.AreaBO;
import com.dilidili.filter.service.entity.dto.FilterDTO;
import com.dilidili.filter.service.entity.vo.FilterVO;
import com.dilidili.filter.service.jobs.RuleArea;
import com.dilidili.filter.service.manager.FilterManager;
import com.dilidili.filter.service.service.FilterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterManager filterManager;

    @Override
    public FilterVO filter(FilterDTO filterDTO, HttpServletRequest request) {
        return filterManager.filter(filterDTO.getText(), AreaBO.builder().area(filterDTO.getArea()).build());
    }
}
