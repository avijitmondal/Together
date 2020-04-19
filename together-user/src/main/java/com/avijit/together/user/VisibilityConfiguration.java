package com.avijit.together.user;

import com.avijit.together.core.util.EnvironmentValuesReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisibilityConfiguration {
    @Bean
    public EnvironmentValuesReader publicEnvironmentValuesReader() {
        return EnvironmentValuesReader.getInstance();
    }

}
