package com.helloworldweb;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestFacade {

	private String url;
	
	@Autowired
	private RestConfig restConfig;
	
	public RestFacade(@Value("${rest.url}") String url) {
		this.url = url;
	}
	
	public Map getRestOutput() {
		Map resultMap = restConfig.getRestTemplate().getForObject(url, Map.class);
		System.out.println("Rest Output = " + resultMap);
		return resultMap;
	}
}
