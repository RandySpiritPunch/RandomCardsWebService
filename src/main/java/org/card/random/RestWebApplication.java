package org.card.random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class RestWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(restWebApplicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(restWebApplicationClass);
    }

    private static Class<RestWebApplication> restWebApplicationClass = RestWebApplication.class;

}
