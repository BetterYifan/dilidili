package com.dilidili.filter.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@RefreshScope
@ConfigurationProperties(prefix = "ratelimiter")
public class RateLimitProperties {

    private Boolean filterServiceLimit = false;

    /**
     * 令牌桶中令牌数，即每秒只发出多少个令牌
     */
    private Integer filterReportNum = 1000;

    /**
     * 可等待令牌时间，单位毫秒
     */
    private Long timeoutMills = 200L;
}
