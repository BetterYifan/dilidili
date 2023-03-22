package com.dilidili.utils;

/**
 * 用户信息获取处理类
 */
public class BodyContext {

    private static final ThreadLocal<String> IN_BODY_PARAM_CONTEXT = new ThreadLocal<>();

    private BodyContext() {
        super();
    }

    public static String getInBodyParamContext() {
        return IN_BODY_PARAM_CONTEXT.get();
    }

    public static void setInBodyParamContext(String param) {
        IN_BODY_PARAM_CONTEXT.set(param);
    }

    public static void removeInBodyParamContext() {
        IN_BODY_PARAM_CONTEXT.remove();
    }
}
