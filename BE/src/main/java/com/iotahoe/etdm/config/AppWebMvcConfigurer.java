package com.iotahoe.etdm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppWebMvcConfigurer implements WebMvcConfigurer {
    /**
     * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
     *           //
     *           registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
     *           // to serve static .html pages...
     *           registry.addResourceHandler("/swagger/**").addResourceLocations("/resources/public/swagger/");
     *           }
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
