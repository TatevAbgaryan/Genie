package com.genie.genie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {

		var source = new ResourceBundleMessageSource();
		source.setBasenames("messages");
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("UTF-8");

		return source;
	}

}