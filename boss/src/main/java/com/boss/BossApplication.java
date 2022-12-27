package com.boss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BossApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BossApplication.class, args);
	}

}
