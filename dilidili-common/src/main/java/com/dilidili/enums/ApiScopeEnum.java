package com.dilidili.enums;

import lombok.Data;

public enum ApiScopeEnum {
    INTERNAL_PUBLIC(0, "内部接口"),

    CLIENT(1, "对端接口");

    private String desc;

    private Integer code;

    ApiScopeEnum(Integer code, String desc) {
        this.code = code;

        this.desc = desc;
    }
}
