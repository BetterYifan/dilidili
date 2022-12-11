package com.dilidili.filter.admin.controller;

import com.dilidili.annotation.ApiScope;
import com.dilidili.filter.admin.annotion.requestLimit.RequestLimit;
import com.dilidili.filter.admin.entity.DTO.AreaContentListDTO;
import com.dilidili.filter.admin.service.AreaContentService;
import com.dilidili.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping("/area/content")
public class AreaContentApi {

    @Autowired
    private AreaContentService areaContentService;

    @RequestLimit(amount = 10, period = 100)
    @PostMapping("/list")
    @ApiScope(urlKey = "101001")
    public String getAreaContentList(@Validated @RequestBody AreaContentListDTO areaContentListDTO, HttpServletRequest request) {
        // 一些公共参数 todo，比如唯一请求id
        if (Objects.isNull(areaContentListDTO)) {
            return ResultUtil.resultWithMessage(500, "xxx");
        }
        return ResultUtil.successWithData(areaContentService.queryAreaContentList(areaContentListDTO, request));
    }

    @RequestLimit(amount = 10, period = 100, desc = "业务添加")
    @PostMapping("/add")
    public void add() {
        System.out.println("add");
    }
}
