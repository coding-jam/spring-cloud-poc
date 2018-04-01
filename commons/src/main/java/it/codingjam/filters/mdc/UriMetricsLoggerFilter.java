package it.codingjam.filters.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UriMetricsLoggerFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UriMetricsLoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        MDC.put("uri", servletRequest.getRequestURI());

        chain.doFilter(request, response);

        MDC.put("status", String.valueOf(servletResponse.getStatus()));
        long elapsed = System.currentTimeMillis() - startTime;
        MDC.put("elapsedInMs", String.valueOf(elapsed));

        LOGGER.info("PERFORM {} with status {} in {}ms", servletRequest.getRequestURI(), servletResponse.getStatus(), elapsed);
    }

    @Override
    public void destroy() {

    }
}
