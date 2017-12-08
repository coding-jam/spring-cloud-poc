package it.codingjam.customerservices;

import it.codingjam.customerservices.resources.CustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServicesApplication.class, args);
	}

	@Bean
	public ResourceConfig resourceConfig() {
	    return new ResourceConfig() {{
	        packages(CustomerResource.class.getPackage().getName());
        }};
    }
}
