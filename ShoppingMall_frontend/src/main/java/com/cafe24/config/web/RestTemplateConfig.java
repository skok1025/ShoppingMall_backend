package com.cafe24.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate getRestTemplate() {
	 	RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
