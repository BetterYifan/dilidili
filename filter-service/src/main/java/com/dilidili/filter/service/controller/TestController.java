package com.dilidili.filter.service.controller;

import com.dilidili.annotation.RequestLimit;
import com.dilidili.filter.service.config.RequestLimitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/filterService/test")
public class TestController {

    @Autowired
    private RequestLimitConfig requestLimitConfig;

    @PostMapping("/aspect/request/limit")
    @RequestLimit()
    public Object TestRequestLimit(HttpServletRequest request) {
        log.info("这是一个测试限流的接口");
        return null;
    }
}
