package it.codingjam.filters.mdc;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PrincipalLoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        MDC.put("user", servletRequest.getUserPrincipal() != null ? servletRequest.getUserPrincipal().getName() : null);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
