package com.kazuweb.crudrest.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springcrudrestsystem-public")
            .pathsToMatch("/api/customers/**", "/api/products/**", "/api/orders/**")
            .build()
    }
}
