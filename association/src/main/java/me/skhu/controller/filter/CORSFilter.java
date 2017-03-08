package me.skhu.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by manki Kim on 2016. 12. 30..
 */
public class CORSFilter implements Filter {

    private String dashboardUrl;

    public CORSFilter(String dashboardUrl) {
        this.dashboardUrl = dashboardUrl;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        response.addHeader("X-Frame-Options", "SAMEORIGIN");
        chain.doFilter(request, res);

    }

    @Override
    public void destroy() {

    }
}
