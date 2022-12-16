package com.dilidili.filter.admin.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "degrade")
public class InterfaceDegradeProperties {

    private Boolean areaList = false;
}
