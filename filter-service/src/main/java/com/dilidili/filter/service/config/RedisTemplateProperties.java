package com.dilidili.filter.service.config;


import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisTemplateProperties {

    @Value()
    private Boolean enabled;
}
