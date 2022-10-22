package com.zy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "acef", urlPatterns = "/*",
//initParams = {
//        @WebInitParam(name = "encoding",value = "UTF-8"),
//        @WebInitParam(name = "k1",value = "v1")
//})
public class AnnotationCharacterEncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
        System.out.println("Encoding:"+encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将Servlet强转为http接口
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse) servletResponse;
        //为请求和响应设置过滤字符集为UTF-8
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);
        //将响应向后传递
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
