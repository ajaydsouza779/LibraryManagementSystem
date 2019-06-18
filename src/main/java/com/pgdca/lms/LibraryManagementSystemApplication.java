package com.pgdca.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.pgdca.lms.config.BeanConfig;
import com.pgdca.lms.config.WebConfig;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan(basePackages = "com.pgdca")
@Import({BeanConfig.class, WebConfig.class})
@EnableAutoConfiguration
@EnableJpaAuditing 
@Slf4j
public class LibraryManagementSystemApplication extends SpringBootServletInitializer{
	private static Class applicationClass = LibraryManagementSystemApplication.class;
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		log.info("SpringApplicationBuilder");
		return application.sources(applicationClass);
    }
}
