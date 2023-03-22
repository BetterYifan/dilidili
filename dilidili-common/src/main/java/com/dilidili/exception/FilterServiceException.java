package com.dilidili.exception;

import lombok.Data;

@Data
public class FilterServiceException extends RuntimeException implements DefinedException {

    private String errorMsg;

    private int errorCode;

    public FilterServiceException(Integer code, String message) {
        super(message);
        this.errorCode = code;
        this.errorMsg = message;
    }

    public FilterServiceException(FilterServiceResponseStatusEnum filterServiceResponseStatusEnum) {
        this.errorCode = filterServiceResponseStatusEnum.getCode();
        this.errorMsg = filterServiceResponseStatusEnum.getMessage();
    }

    @Override
    public String message() {
        return null;
    }
}
