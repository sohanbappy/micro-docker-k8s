package com.admission.service;

import com.admission.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AdmissionService {

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
}
