package com.dilidili.enums;

import lombok.Data;

public enum ErrorCodeIntEnum {
    Degrade(10001, "接口降级"),

    ParamError(400, "请求参数有误"),
    InternalError(500, "服务内部错误");

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer code;

    private String message;

    ErrorCodeIntEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
