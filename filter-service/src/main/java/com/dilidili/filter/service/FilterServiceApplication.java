package com.dilidili.filter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.dilidili")
@EnableDiscoveryClient
@ServletComponentScan
public class FilterServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterServiceApplication.class);
    }
}
