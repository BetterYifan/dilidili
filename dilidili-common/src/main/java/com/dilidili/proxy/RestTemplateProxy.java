package com.dilidili.proxy;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.dilidili.enums.ProxyExceptionEnum;
import com.dilidili.exception.ProxyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

/**
 * restTemplate的代理类
 */
@Component
@Slf4j
public class RestTemplateProxy {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "loadBalancedRestTemplate")
    private RestTemplate loadBalancedRestTemplate;

    public <T> T exchangeByPost(String url, @Nullable HttpEntity<?> requestEntity, Class<T> responseType)
            throws ProxyException {
        if (StringUtils.isEmpty(url) || Objects.isNull(requestEntity) || Objects.isNull(responseType)) {
            log.error("RestTemplateProxy.exchangeByPost: params error, url:{}, responseType:{}",
                    url, responseType);
            throw new ProxyException(ProxyExceptionEnum.INVALID_PARAMS);
        }
        ResponseEntity<T> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
        } catch (HttpClientErrorException e) {
            log.error("RestTemplateProxy.exchangeByPost: url:{}, exception:{}",
                    url, e.getMessage());
            throw e;
        }

        return responseEntity.getBody();
    }
}
