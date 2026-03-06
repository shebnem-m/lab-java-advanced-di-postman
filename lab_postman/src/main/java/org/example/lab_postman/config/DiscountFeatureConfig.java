package org.example.lab_postman.config;

import org.example.lab_postman.service.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountFeatureConfig{
    @Bean
    @ConditionalOnProperty(name="feature.earlybird.enabled", havingValue = "true", matchIfMissing = false)
    public EarlyBirdDiscountService earlyBirdDiscountService(){
        return new EarlyBirdDiscountService();
    }
}



