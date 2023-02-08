package com.dilidili.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ProxyExceptionEnum {
    INVALID_PARAMS("1001", "invalid params"),
    CLIENT_ERROR("1002", "client error");

    private String code;

    private String desc;

    ProxyExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
