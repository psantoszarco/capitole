package com.project.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		
		System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		SpringApplication.run(Application.class, args);
	}
}
