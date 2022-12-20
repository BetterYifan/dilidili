package com.dilidili.filter.admin.interceptor;

import com.dilidili.annotation.ValidateRequest;
import com.dilidili.utils.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Slf4j
@Component
public class ValidateInterceptor implements HandlerInterceptor {

    private static final String TraceId = "trace-id";

    /**
     * 在Controller之前调用，返回false，controller不执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("ValidateInterceptor preHandle request: [" + request.getRequestURL() + ".]");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        ValidateRequest validateRequest = method.getAnnotation(ValidateRequest.class);

        if (!validateRequest.needCheck()) {
            return true;
        }
        // 填充traceId
        String traceId = getTraceId(request);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private String getTraceId(HttpServletRequest request) {
        String traceId = request.getHeader(TraceId);
        if (StringUtils.isBlank(traceId)) {
            traceId = TraceIdUtil.getTraceId();
        }
        return traceId;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
