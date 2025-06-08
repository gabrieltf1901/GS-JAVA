// src/main/java/com/gestaoabrigos/config/MvcConfig.java
package com.gestaoabrigos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // GET /login → login.html
        registry.addViewController("/login").setViewName("login");
        // opcional: GET / → index.html
        registry.addViewController("/").setViewName("index");
    }
}
