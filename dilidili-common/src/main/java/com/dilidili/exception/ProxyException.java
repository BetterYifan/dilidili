package com.dilidili.exception;

import com.dilidili.enums.ProxyExceptionEnum;
import lombok.Data;

@Data
public class ProxyException extends RuntimeException implements DefinedException {
    private ProxyExceptionEnum proxyExceptionEnum;

    public ProxyException(ProxyExceptionEnum exceptionEnum) {
        this.proxyExceptionEnum = exceptionEnum;
    }

    @Override
    public String message() {
        return proxyExceptionEnum.getDesc();
    }
}
