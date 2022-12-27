package com.patient.controller;

import com.patient.entity.Patient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@RestController
@RequestMapping("/patient")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "Hello from Patient!!";
    }

    @RequestMapping("/admin")
    public String adminTest() {
        return "Hello from Patient (Admin)!!";
    }

    @RequestMapping("/operator")
    public String operatorTest() {
        return "Hello from Patient (Operator)!!";
    }

    @RequestMapping("/all")
    public List<Patient> allPatients() {
        return Stream.of(new Patient(1, "sohan", "01766"),
                new Patient(2, "rayhan", "01866")).collect(Collectors.toList());
    }

}
