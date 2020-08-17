package pers.jamie.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用于判断是否登录的过滤器
 */
//@WebFilter(value = "/*")
public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        先判断是否为登录界面  若是直接放行
//        1.给servletrequest强转为Httpservelet   因为我们需要获取url
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if (uri.contains("/homepage.jsp") || uri.contains("/register.jsp")
                || uri.contains("/register_ok.jsp") || uri.contains("/checkCodeServlet")
                || uri.contains("/css") || uri.contains("/fonts") || uri.contains("/js")
                || uri.contains("/img") || uri.contains("/loginServlet")
                || uri.contains("/registerServlet") || uri.contains("/loginServlet")
                || uri.contains("/loginServlet") || uri.contains("/loginServlet")) {
//           若为登录界面直接放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
//            若不是登录界面判断是否登录过  若是 放行  不是  跳转到 登录界面并提示
            Object user = request.getSession().getAttribute("user");
            if (user != null) {

                //已登录
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
//                跳转到登录界面并提示未登录
                request.setAttribute("img", "您未登录，请先登录");
                request.getRequestDispatcher("/homepage.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
