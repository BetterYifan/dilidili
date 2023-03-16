package com.dilidili.filter.service.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import java.io.IOException;

@Component
public class InBodyFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
