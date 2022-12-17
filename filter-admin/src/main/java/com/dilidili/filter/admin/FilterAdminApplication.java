package com.dilidili.filter.admin;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.dilidili")
@EnableDiscoveryClient
// 路径设置为infra模块的mapper路径
@MapperScan(basePackages = {"com.dilidili.mapper"})
public class FilterAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterAdminApplication.class, args);
    }

}
