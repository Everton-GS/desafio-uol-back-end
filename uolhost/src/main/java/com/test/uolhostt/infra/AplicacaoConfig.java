package com.test.uolhostt.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AplicacaoConfig {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
