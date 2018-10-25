package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext vSpringApplicationContext = 
				SpringApplication.run(HelloWorldApplication.class, args);
		
		System.out.println(vSpringApplicationContext);
		
		Product vProduct = vSpringApplicationContext.getBean(Product.class);
		
		System.out.println("Printing Product Object: " + vProduct);
		
		System.out.println("Injected Item Dependancy: " + vProduct.getItem().toString());
	}
}
