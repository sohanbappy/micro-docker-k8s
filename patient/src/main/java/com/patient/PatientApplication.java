package com.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PatientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

}
