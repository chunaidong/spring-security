package com.wangmike.security.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 11:22
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method start");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         long startTime = System.currentTimeMillis();
        System.out.println("doFilter Method start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("耗时 ：：" + (System.currentTimeMillis() - startTime));
    }

    @Override
    public void destroy() {
        System.out.println("destory method start");
    }
}
