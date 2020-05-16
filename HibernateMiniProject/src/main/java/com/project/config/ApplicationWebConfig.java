package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.project")
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class ApplicationWebConfig {
	@Autowired
	Environment environment;
    
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();

		viewResolver.setPrefix(environment.getProperty("mvc.prefix"));
		viewResolver.setSuffix(environment.getProperty("mvc.suffix"));

		return viewResolver;
	}

}
