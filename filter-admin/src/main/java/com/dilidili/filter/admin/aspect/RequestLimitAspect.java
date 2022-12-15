package com.dilidili.filter.admin.aspect;

import com.dilidili.filter.admin.annotion.RequestLimit;
import com.dilidili.filter.admin.config.RequestLimitConfig;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 自定义注解，用于service方法的增强,AOP
 * 限流应该是拦截器or过滤器？不应该是放在切面里去做
 */

@Aspect
@Component
public class RequestLimitAspect {

    //    private final String POINT = "execution(* com.dilidili.filter.admin.annotion.requestLimit(..))";
    private final String POINT = "@annotation (com.dilidili.filter.admin.annotion.RequestLimit)";

    @Autowired
    private RequestLimitConfig requestLimitConfig;

    @Pointcut(POINT)
    public void pointcut() {

    }

    /**
     * 在切面之前执行
     */
    @Before("pointcut()")
    public void doBefore() {
        System.out.println("before");
    }

    /**
     * 方法前执行
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long begin = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        RequestLimit requestLimit = method.getAnnotation(RequestLimit.class);
        String desc = requestLimit.desc();

        System.out.println("========请求开始======");
        System.out.printf("请求链接：%s", request.getRequestURI().toString());
        System.out.println();
        System.out.printf("请求描述：%s", desc);
        System.out.println();

        Object proceed = null;
        // 此行代码代表执行目标方法之前要执行上面的代码
        try {
            proceed = point.proceed();
        } catch (Exception e) {
            System.out.println("do end");
        }
        return proceed;
    }

    /**
     * 切面之后
     */
    @After("pointcut()")
    public void doAfter() {
        System.out.println("after");
    }
}
