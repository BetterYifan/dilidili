package com.dilidili.annotation;

import com.dilidili.enums.ApiScopeEnum;

import java.lang.annotation.*;

/**
 * 标记路由级别
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ApiScope {
    String urlKey() default "";

    ApiScopeEnum scope() default ApiScopeEnum.CLIENT;
}
