package com.fusion.prod.spring.config;

import org.codehaus.plexus.component.annotations.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .resourceChain(true);
    }

}
