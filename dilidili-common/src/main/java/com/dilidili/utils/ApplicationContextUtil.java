package com.dilidili.utils;

import com.alibaba.nacos.common.utils.StringUtils;
import com.dilidili.annotation.ApiScope;
import com.dilidili.enums.ApiScopeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import javax.servlet.ServletContext;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ApplicationContextUtil {

    private static Map<String, String> needRegisterApi = Collections.synchronizedMap(new HashMap<>());

    private static Map<String, String> noNeedRegisterApi = Collections.synchronizedMap(new HashMap<>());

    public static void initApis(WebApplicationContext webApplicationContext) {
        // 取出所有路由mappings
        RequestMappingHandlerMapping requestMappingHandlerMapping = webApplicationContext.getBean(RequestMappingHandlerMapping.class);
        //
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        String contextPath = "";
        ServletContext servletContext = webApplicationContext.getServletContext();
        if (Objects.nonNull(servletContext)) {
            contextPath = servletContext.getContextPath();
        }

        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : map.entrySet()) {
            RequestMappingInfo rmi = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();

            PathPatternsRequestCondition pathPatternsCondition = rmi.getPathPatternsCondition();
            List<String> pathList = new ArrayList<>();
            if (pathPatternsCondition != null) {
                Set<PathPattern> patterns = pathPatternsCondition.getPatterns();
                for (PathPattern p :
                        patterns) {
                    pathList.add(p.getPatternString());
                }
            }
            if (Objects.nonNull(handlerMethod)) {
                Method method = handlerMethod.getMethod();
                ApiScope apiScope = method.getAnnotation(ApiScope.class);
                if (Objects.nonNull(apiScope)) {
                    String path = "";
                    if (pathList.size() > 0) {
                        path = contextPath + pathList.get(0);
                    }
                    // 如果urlKey为空，采用全路径
                    String urlKey = apiScope.urlKey();
                    if (StringUtils.isBlank(urlKey)) {
                        urlKey = path;
                    }
                    if (ApiScopeEnum.CLIENT.equals(apiScope.scope())) {
                        needRegisterApi.put(urlKey, path);
                    } else {
                        noNeedRegisterApi.put(urlKey, path);
                    }
                }

            }
        }
    }

    public static Map<String, String> getNeedRegisterApi() {
        return needRegisterApi;
    }
}
