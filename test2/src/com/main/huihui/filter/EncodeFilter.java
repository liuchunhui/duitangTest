package com.main.huihui.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huihui on 15-3-25.
 */
public class EncodeFilter implements Filter{

    private FilterConfig config;

    @Override
    public void init(FilterConfig config) {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{

        String charset = config.getInitParameter("charset");

        System.out.println(charset);

        if (charset == null) {
            charset = "UTF-8";
        }

        // 过滤器实现请求转码
        request.setCharacterEncoding(charset);
    }

    @Override
    public void destroy() {

    }
}
