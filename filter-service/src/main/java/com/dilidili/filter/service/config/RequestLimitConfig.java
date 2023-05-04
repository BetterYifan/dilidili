package com.dilidili.filter.service.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 限流配置，针对接口级别，多纬度
 */
@Data
@Component
@ConfigurationProperties(prefix = "request")
public class RequestLimitConfig {

    private Integer defaultAmount;


    private TestRequestLimitInterface testRequestLimitInterface;

    @Data
    @ConfigurationProperties(prefix = "request.test")
    public class TestRequestLimitInterface {
        private Integer amount;

        private Long period;
    }
}
