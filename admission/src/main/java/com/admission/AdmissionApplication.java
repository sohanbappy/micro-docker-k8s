package com.admission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AdmissionApplication extends SpringBootServletInitializer {

	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate(RestTemplateBuilder builder){
		return builder.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(AdmissionApplication.class, args);
	}

}
