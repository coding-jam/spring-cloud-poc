package it.codingjam.orderservices.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebFilter("/api/*")
public class SleuthHeadersLogger implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SleuthHeadersLogger.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String headers = Collections.list(request.getHeaderNames()).stream()
                .filter(h -> h.startsWith("x-b3-"))
                .map(h -> h + ": " + request.getHeader(h))
                .collect(Collectors.joining("\n"));

        LOGGER.info("Sleuth headers: \n\n" + headers + "\n");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
