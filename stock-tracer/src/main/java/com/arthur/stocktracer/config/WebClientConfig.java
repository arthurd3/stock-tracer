package com.arthur.stocktracer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder ,
                               @Value("${alpha.base.api.url}") String stringUrl) {
        return builder.baseUrl(stringUrl).build();
    }
}
