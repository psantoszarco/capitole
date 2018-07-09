package com.project.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {
	
	 
	 public static void main(String[] args) throws Exception {
		 System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		 SpringApplication.run(Application.class, args);
	 }

}
