package com.dilidili.filter.admin.aspect;

import com.dilidili.annotation.RequestLimit;
import com.dilidili.exception.RateLimitException;
import com.dilidili.filter.admin.config.RequestLimitConfig;
import lombok.extern.slf4j.Slf4j;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义注解，用于service方法的增强,AOP
 * 限流应该是拦截器or过滤器？不应该是放在切面里去做
 */

@Aspect
@Component
@Slf4j
public class RequestLimitAspect {

    /**
     * 切点函数
     * 1. execution(方法修饰符(可选)  返回类型  方法名  参数  异常模式(可选))
     * 2. @annotation(): 表示了标注指定注解的目标类方法
     * 3. args(): 通过目标类方法的参数类型指定切点,例如 args(String) 表示有且仅有一个String型参数的方法
     */
    //    private final Strinnnotation()g POINT = "execution(* com.dilidili.filter.admin.annotion.requestLimit(..))";

    /**
     * 切点
     */
    private final String POINT = "@annotation (com.dilidili.annotation.RequestLimit)";

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        log.info("执行限流切面start：" + simpleDateFormat.format(new Date()));
    }

    /**
     * 方法前执行
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        RequestLimit requestLimit = method.getAnnotation(RequestLimit.class);

        log.info("========请求开始======");
        log.info("请求链接：%s\n", request.getRequestURI());

        Object proceed = null;
        // 此行代码代表执行目标方法之前要执行上面的代码
        try {
            boolean filter = handle(requestLimit);
            if (filter) {
                throw new RateLimitException();
            }
            proceed = point.proceed();
        } catch (Exception e) {
            log.error("requestLimit exception: {}", (Object) e.getStackTrace());
        }
        return proceed;
    }

    private boolean handle(RequestLimit requestLimit) {
        //todo redis incr限流
        return false;
    }

    /**
     * 切面之后
     */
    @After("pointcut()")
    public void doAfter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        log.info("执行限流切面end：" + simpleDateFormat.format(new Date()));
    }
}
