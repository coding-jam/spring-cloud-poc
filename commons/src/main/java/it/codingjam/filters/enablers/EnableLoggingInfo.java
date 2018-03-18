package it.codingjam.filters.enablers;

import it.codingjam.filters.config.LoggingFiltersConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LoggingFiltersConfig.class)
public @interface EnableLoggingInfo {
}
