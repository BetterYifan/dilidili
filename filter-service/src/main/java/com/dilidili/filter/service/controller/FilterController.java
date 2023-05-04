package com.dilidili.filter.service.controller;

import com.dilidili.annotation.InterfaceLogging;
import com.dilidili.exception.FilterServiceException;
import com.dilidili.exception.FilterServiceResponseStatusEnum;
import com.dilidili.filter.service.config.RateLimitProperties;
import com.dilidili.filter.service.entity.dto.FilterDTO;
import com.dilidili.filter.service.service.FilterService;
import com.dilidili.utils.ResultUtil;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Slf4j
@RestController
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private FilterService filterService;

    @Autowired
    private RateLimitProperties rateLimitProperties;

    @Autowired
    @Qualifier("filterRateLimiter")
    private RateLimiter filterRateLimiter;

    @PostMapping("")
    @InterfaceLogging
    public String Filter(@RequestBody FilterDTO filterDTO, HttpServletRequest request) {

        // 限流判断，与业务耦合，实际情况可以考虑gateway、nginx等中间件
        if (BooleanUtils.isTrue(rateLimitProperties.getFilterServiceLimit())) {
            Duration timeout = Duration.of(rateLimitProperties.getTimeoutMills(), ChronoUnit.MILLIS);
            boolean limitFlag = filterRateLimiter.tryAcquire(timeout);
            if (!limitFlag) {
                log.error("filter traffic limiting");
                throw new FilterServiceException(FilterServiceResponseStatusEnum.TRAFFIC_LIMITING);
            }
        }

        // todo 参数校验
        return ResultUtil.successWithData(filterService.filter(filterDTO, request));
    }

}
