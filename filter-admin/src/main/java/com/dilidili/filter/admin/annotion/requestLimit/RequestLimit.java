package com.dilidili.filter.admin.annotion.requestLimit;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Request请求次数拦截  自定义注解
 *
 * @author zyf
 * @date 2022.08.14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(1)
public @interface RequestLimit {
    /**
     * 允许访问次数，默认100
     *
     * @return
     */
    int amount() default 100;

    /**
     * 时间，单位毫秒
     *
     * @return
     */
    long period() default 60000;

    /*
    请求描述
     */
    String desc() default "";
}
