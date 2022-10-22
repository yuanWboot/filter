package com.zy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeviceAdapterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //将Servlet强转为http接口
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String uri = req.getRequestURI();//index.html >>/desktop/index.html  >>/mobile/index.html
        String userAgent = req.getHeader("user-agent");
        String targetUri = null;
        //移动端的URI
        if(userAgent.toLowerCase().indexOf("android")!=-1 ||userAgent.toLowerCase().indexOf("iphone")!=-1){
            targetUri = "/mobile"+uri;
        }else {
            //桌面端的URI
            targetUri = "/desktop"+uri;
        }

    }

    @Override
    public void destroy() {

    }
}
