package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DiscountFeatureConfig{
    @Bean
    @ConditionalOnProperty(name="feature.earlybird.enabled", havingValue = "true", matchIfMissing = false)
    public EarlyBirdDiscountService earlyBirdDiscountService(){
        return new EarlyBirdDiscountService();
    }
}



