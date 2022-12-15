package com.dilidili.filter.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * RequestLimitConfig
 */
@ConfigurationProperties(prefix = "request-limit")
@Component
@Data
public class RequestLimitConfig {
    /**
     * 是否开启配置
     */
    private Boolean enable;

    /**
     * 允许访问数量
     */
    private int amount;

    /**
     * 时间段
     */
    private long period;
}
