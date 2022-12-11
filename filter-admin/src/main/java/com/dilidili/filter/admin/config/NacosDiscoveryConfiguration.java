package com.dilidili.filter.admin.config;

import com.alibaba.cloud.nacos.ConditionalOnNacosDiscoveryEnabled;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.discovery.NacosWatch;
import com.dilidili.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.CommonsClientAutoConfiguration;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@Configuration
@ConditionalOnNacosDiscoveryEnabled
@AutoConfigureBefore({SimpleDiscoveryClientAutoConfiguration.class, CommonsClientAutoConfiguration.class})
public class NacosDiscoveryConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = {"spring.cloud.nacos.discovery.watch.enabled"}, matchIfMissing = true)
    public NacosWatch nacosWatch(NacosServiceManager nacosServiceManager, NacosDiscoveryProperties nacosDiscoveryProperties,
                                 ObjectProvider<ThreadPoolTaskScheduler> taskScheduler, WebApplicationContext webApplicationContext) {
        ApplicationContextUtil.initApis(webApplicationContext);
        // 添加服务注册时间
        nacosDiscoveryProperties.getMetadata().put("startup.time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        // 自定义接口元数据
        for (Map.Entry<String, String> api : ApplicationContextUtil.getNeedRegisterApi().entrySet()) {
            nacosDiscoveryProperties.getMetadata().put(api.getKey(), api.getValue());
        }

        return new NacosWatch(nacosServiceManager, nacosDiscoveryProperties, taskScheduler);
    }
}
