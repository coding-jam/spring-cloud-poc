package it.codingjam.orderservices;

import it.codingjam.orderservices.resources.OrderResource;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@EnableFeignClients
@SpringBootApplication
public class OrderServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServicesApplication.class, args);
    }

    @Bean
    public ResourceConfig resourceConfig() {
        return new ResourceConfig() {{
            packages(OrderResource.class.getPackage().getName());
            register(LoggingFeature.class);
        }};
    }
}
