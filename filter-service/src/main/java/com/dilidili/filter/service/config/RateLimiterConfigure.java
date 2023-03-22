package com.dilidili.filter.service.config;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({RateLimitProperties.class})
public class RateLimiterConfigure {

    @Autowired
    private RateLimitProperties rateLimitProperties;

    @Bean(name = "filterRateLimiter")
    public RateLimiter getFilterRateLimiter() {
        return RateLimiter.create(rateLimitProperties.getFilterReportNum());
    }
}
