package com.admission.service;

import com.admission.hystrix.CommonHystrixCommand;
import com.admission.model.Doctor;
import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class AdmissionService {

    @Autowired
    HystrixCommand.Setter setter;
    @Autowired
    private RestTemplate restTemplate;

    public List<Doctor> getDoctorList() {
        List<Doctor> docs = restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/all", List.class);
        return docs;
    }

     public Doctor getDoctor(int id) {
        Doctor doc = restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/" + id, Doctor.class);
        return doc;
    }

    public Doctor getDoctorWithHystrix(int id) throws ExecutionException, InterruptedException {
        CommonHystrixCommand<Doctor> customerCommonHystrixCommand = new CommonHystrixCommand<>(setter, () ->
                restTemplate.getForObject("http://DOCTOR-SERVICE/doctor/" + id, Doctor.class), () -> new Doctor());

        Future<Doctor> doctorFuture=customerCommonHystrixCommand.queue();
        return doctorFuture.get();
    }
}
