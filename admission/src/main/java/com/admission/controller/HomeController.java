package com.admission.controller;

import com.admission.model.Doctor;
import com.admission.service.AdmissionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/admission")
@RefreshScope
@EnableAutoConfiguration
public class HomeController {

    @Autowired
    private AdmissionService admissionService;

    @RequestMapping("/home")
    public String home() {
        return "Hello from Admission!!";
    }

    @RequestMapping("/allDoctors")
    public List<Doctor> getAllDoctors() {
        return admissionService.getDoctorList();
    }

    @RequestMapping("/getDoctor/{Id}")
    public Doctor getDoctorById(@PathVariable("Id") int id) {
        return admissionService.getDoctor(id);
    }

    @RequestMapping("/getDoctorWithHystrix/{Id}")
    public Doctor getDoctorByIdWithHystrix(@PathVariable("Id") int id) throws ExecutionException, InterruptedException {
        return admissionService.getDoctorWithHystrix(id);
    }

    @RequestMapping("/getDoctorWithHystrixCommand/{Id}")
    @HystrixCommand(fallbackMethod = "getDoctorFallBack")
    public Doctor getDoctorByIdWithHystrixCommand(@PathVariable("Id") int id) throws ExecutionException, InterruptedException {
        return admissionService.getDoctorWithHystrix(id);
    }


    /*
        Fallbacks
     */
    private Doctor getDoctorFallBack(){
        return new Doctor("someone", "01712345678", "default");
    }

}
