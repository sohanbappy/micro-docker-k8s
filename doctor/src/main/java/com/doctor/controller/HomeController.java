package com.doctor.controller;

import com.doctor.model.Doctor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctor")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {

    private List<Doctor> doctorList = Arrays.asList(
            new Doctor(1, "Sohan", "01755334885","Surgeon"),
            new Doctor(2, "Bappy", "01515205145","Orthopedics")
    );

    @RequestMapping("/home")
    public String home(){
        return "Hello form Doctor!!!";
    }
    @RequestMapping("/all")
    public List<Doctor> getDoctorList(){
        return doctorList;
    }

    @RequestMapping("/{Id}")
    public Doctor findDoctorById(@PathVariable("Id") int Id){
        Doctor d = doctorList.stream()
                .filter(doctor -> String.valueOf(Id).equals(String.valueOf(doctor.getId())))
                .findAny()
                .orElse(null);

        return d;
    }
}
