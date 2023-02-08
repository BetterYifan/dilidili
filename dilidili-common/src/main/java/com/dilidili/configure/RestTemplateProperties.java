package com.dilidili.configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "http-pool")
public class RestTemplateProperties {
    /**
     * 整个连接池的最大连接数
     */
    private int maxTotal = 300;

    /**
     * 每个route默认的最大连接数
     */
    private int maxPerRoute = 100;

    private int connectTimeout = 1000;

    private int connectionRequestTimeout = 1000;

    /**
     * 客户端与服务端数据交互的超时时间
     */
    private int socketTimeout = 2000;

    private int validateAfterInactivity = 2000;

    private long keepAliveTime = 60 * 1000;
}
