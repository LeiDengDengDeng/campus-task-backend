package com.net;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CampusApplication extends WebMvcConfigurerAdapter {

	@Value("${web.upload.path}")
	private String uploadPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/uploads/**").addResourceLocations(
				"file:"+uploadPath);

	}

	public static void main(String[] args) {
		SpringApplication.run(CampusApplication.class, args);
	}
}
