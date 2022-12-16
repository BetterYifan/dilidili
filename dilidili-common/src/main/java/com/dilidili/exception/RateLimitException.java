package com.dilidili.exception;

public class RateLimitException extends Exception implements DefinedException {
    @Override
    public String message() {
        return "接口限流";
    }
}
