package it.codingjam.filters.mdc;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UriMetricsLoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        MDC.put("uri", servletRequest.getRequestURI());
        MDC.put("status", String.valueOf(servletResponse.getStatus()));
        MDC.put("elapsedInMs", String.valueOf(System.currentTimeMillis() - startTime));
    }

    @Override
    public void destroy() {

    }
}
