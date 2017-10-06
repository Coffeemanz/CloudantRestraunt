package com.iba.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@PropertySources({
        @PropertySource("classpath:cloudant.properties"),
        @PropertySource("classpath:apiSwaggerInfo.properties")
})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPSPC(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
