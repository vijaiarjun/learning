package com.helloworldweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	public RestOperations getRestTemplate() {
		return new RestTemplate();
	}
}
