package com.project.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		
		System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		SpringApplication.run(Application.class, args);
	}
}
