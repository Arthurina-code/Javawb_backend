package io.github.xxyopen.novel.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.Logbook;

import static org.zalando.logbook.core.Conditions.*;

/**
 * Logbook Configuration
 */
@Configuration
public class LogbookConfig {

    @Bean
    public Logbook logbook() {
        return Logbook.builder()
                .condition(exclude(
                        // Ignore OPTIONS requests
                        requestWithMethod("OPTIONS"),
                        // Ignore requests to /actuator and its subpaths (provided by Spring Boot Actuator)
                        requestTo("/actuator/**"),
                        // Ignore Swagger documentation paths
                        requestTo("/swagger-ui/**"),
                        requestTo("/v3/api-docs/**"),
                        // Ignore binary file requests
                        contentType("application/octet-stream"),
                        // Ignore file upload requests
                        contentType("multipart/form-data")
                ))
                .build();
    }

}

