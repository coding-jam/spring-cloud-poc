package it.codingjam.zuulgateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class UriLogger implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UriLogger.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Initializing " + UriLogger.class.getName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Requested URI: {}", ((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("Destroying " + UriLogger.class.getName());
    }
}
