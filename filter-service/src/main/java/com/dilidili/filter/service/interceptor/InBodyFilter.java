package com.dilidili.filter.service.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import java.io.IOException;

@Component
@WebFilter(filterName = "inBody")
public class InBodyFilter implements Filter {

    /**
     * 只在项目启动的时候执行一次
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("inbody filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("begin filter");
        filterChain.doFilter(servletRequest, servletResponse);
        // 执行完业务handler后执行的方法
        System.out.println("end filter");
    }
}
