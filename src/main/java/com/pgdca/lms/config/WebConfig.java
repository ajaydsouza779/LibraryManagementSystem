package com.pgdca.lms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.js/**").addResourceLocations("/ui/static/JS");
		registry.addResourceHandler("/*.css/**").addResourceLocations("/ui/static/CSS/"); 
		//registry.addResourceHandler("/*.jpg/**").addResourceLocations("/ui/static/MEDIA/"); 
		registry.addResourceHandler("/*.png/**", "/*.jpg/**").addResourceLocations("/ui/static/MEDIA/"); 
	}

}
