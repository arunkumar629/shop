package com.arun.shop.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	exposeDirectory("user-photos", registry);	
    }
    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
    	Path uploadDir = Paths.get(dirName);
    	String uploadPath = uploadDir.toFile().getAbsolutePath();
    	if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
    	registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
    }
    }
