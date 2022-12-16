package com.dilidili.filter.admin.controller;

import com.dilidili.annotation.ApiScope;
import com.dilidili.filter.admin.config.InterfaceDegradeProperties;
import com.dilidili.enums.ErrorCodeIntEnum;
import com.dilidili.annotation.RequestLimit;
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

    @Autowired
    private InterfaceDegradeProperties interfaceDegradeProperties;

    @RequestLimit(amount = 100, period = 100, desc = "查询业务词列表")
    @PostMapping("/list")
    @ApiScope(urlKey = "101001")
    public String getAreaContentList(@Validated @RequestBody AreaContentListDTO areaContentListDTO, HttpServletRequest request) {
        // 降级
        if (interfaceDegradeProperties.getAreaList()) {
            return ResultUtil.responseWithCodeEnum(ErrorCodeIntEnum.Degrade);
        }
        // 一些公共参数 todo，比如唯一请求id
        if (Objects.isNull(areaContentListDTO)) {
            return ResultUtil.responseWithCodeEnum(ErrorCodeIntEnum.ParamError);
        }
        return ResultUtil.successWithData(areaContentService.queryAreaContentList(areaContentListDTO, request));
    }

    @RequestLimit(amount = 10, period = 100, desc = "业务词库添加")
    @PostMapping("/add")
    @ApiScope(urlKey = "101002")
    public void addAreaContent() {
        System.out.println("add");
    }

    @RequestLimit(amount = 10, period = 100, desc = "更新业务词内容")
    @PostMapping("/update")
    @ApiScope(urlKey = "101003")
    public void updateAreaContent() {
        System.out.println("update");
    }


    @RequestLimit(amount = 10, period = 100, desc = "删除业务敏感词")
    @PostMapping("/delete")
    @ApiScope(urlKey = "101004")
    public void deleteAreaContent() {
        System.out.println("delete");
    }
}
