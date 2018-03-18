package it.codingjam.filters.mdc;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestRemoteIpLoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String ip;
        if ((ip = servletRequest.getHeader("X-Forwarded-For")) != null) {
            MDC.put("ip", ip);
        } else {
            MDC.put("ip", request.getRemoteAddr());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
