package com.dilidili.filter.service.config;

import com.dilidili.utils.BodyContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@WebFilter(filterName = "InBody")
public class InBodyFilter implements Filter {

    /**
     * 只在项目启动的时候执行一次
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 文件类型，则放过；如果是post请求的body参数，直接通过读取流的方式放到上下文
        String contentType = servletRequest.getContentType();
        if (!StringUtils.isEmpty(contentType) && contentType.contains("multipart/form-data")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ContentCachingRequestWrapper contentCachingRequestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
            // 这个body 是post的body
            String body = IOUtils.toString(contentCachingRequestWrapper.getBody(), servletRequest.getCharacterEncoding());
            BodyContext.setInBodyParamContext(body);
            // 注意这里使用新的request
            filterChain.doFilter(contentCachingRequestWrapper, servletResponse);
            BodyContext.removeInBodyParamContext();
        }
    }
}
