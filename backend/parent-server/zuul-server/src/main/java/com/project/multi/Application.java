package com.project.multi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableZuulProxy
@EnableDiscoveryClient
public class Application {

	public static void main(String args[]) {
		System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
