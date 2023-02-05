package com.dilidili.filter.service.controller;

import com.dilidili.filter.service.entity.dto.FilterDTO;
import com.dilidili.filter.service.service.FilterService;
import com.dilidili.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private FilterService filterService;

    @PostMapping("")
    public String Filter(@RequestBody FilterDTO filterDTO, HttpServletRequest request) {
        // todo 参数校验
        return ResultUtil.successWithData(filterService.filter(filterDTO, request));
    }
}
