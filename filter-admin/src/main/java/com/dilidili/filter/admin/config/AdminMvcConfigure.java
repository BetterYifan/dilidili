package com.dilidili.filter.admin.config;

import com.dilidili.filter.admin.interceptor.ValidateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AdminMvcConfigure implements WebMvcConfigurer {

    @Value("${application.ignoreUrls}")
    private List<String> ignoreUrls;

    @Autowired
    private ValidateInterceptor validateInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(validateInterceptor).addPathPatterns("/**").excludePathPatterns(ignoreUrls);
    }

}
