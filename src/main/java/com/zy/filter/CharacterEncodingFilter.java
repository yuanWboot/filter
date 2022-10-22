package com.zy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       //将Servlet强转为http接口
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletRequest reqs =(HttpServletRequest) servletResponse;
    }

    @Override
    public void destroy() {

    }
}
