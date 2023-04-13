package com.dilidili.exception;

import lombok.Getter;

@Getter
public enum FilterServiceResponseStatusEnum {
    SUCCESS(0, "SUCCESS"),

    TRAFFIC_LIMITING(601, "traffic limiting");

    private int code;

    private String message;

    FilterServiceResponseStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
