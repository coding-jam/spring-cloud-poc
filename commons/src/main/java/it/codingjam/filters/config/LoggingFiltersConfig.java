package it.codingjam.filters.config;

import it.codingjam.filters.mdc.PrincipalLoggerFilter;
import it.codingjam.filters.mdc.RequestRemoteIpLoggerFilter;
import it.codingjam.filters.mdc.UriMetricsLoggerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

public class LoggingFiltersConfig {

    @Bean
    public FilterRegistrationBean principalLoggerFilter() {
        return getFilterRegistrationBean(new PrincipalLoggerFilter(), 1);
    }

    @Bean
    public FilterRegistrationBean requestRemoteIpLoggerFilter() {
        return getFilterRegistrationBean(new RequestRemoteIpLoggerFilter(), 2);
    }

    @Bean
    public FilterRegistrationBean uriMetricsLoggerFilter() {
        return getFilterRegistrationBean(new UriMetricsLoggerFilter(), 3);
    }

    private FilterRegistrationBean getFilterRegistrationBean(Filter filter, int order) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/*");
        registration.setOrder(order);
        registration.setFilter(filter);
        return registration;
    }
}
