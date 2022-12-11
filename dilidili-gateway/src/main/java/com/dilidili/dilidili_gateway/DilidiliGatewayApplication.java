package com.dilidili.dilidili_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DilidiliGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DilidiliGatewayApplication.class, args);
    }

}
