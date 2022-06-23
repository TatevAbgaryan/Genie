package com.genie.genie;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = { "com.genie.genie" })
public class WebConfig implements WebMvcConfigurer {

	private static final List<Locale> SUPPORTED_LOCALES = Arrays.asList(Locale.ENGLISH);

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
		resolver.setSupportedLocales(SUPPORTED_LOCALES);

		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
