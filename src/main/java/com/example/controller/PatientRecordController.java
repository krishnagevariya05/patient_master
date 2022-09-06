package com.example.controller;

import com.example.model.patient;
import com.example.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRepository;

    @GetMapping("/patients")
    public List<patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public patient getPatient(@PathVariable Integer id) {
        return patientRepository.findById(id).get();
    }

    @PostMapping("/patient")
    public List<patient> addPatient(@RequestBody patient patient1) {
        patientRepository.save(patient1);
        return patientRepository.findAll();
    }

    @PutMapping("/patient/{id}")
    public List<patient> updatePatient(@RequestBody patient patient1, @PathVariable Integer id) {
        patient patientObj = patientRepository.findById(id).get();
        patientObj.setName(patient1.getName());
        patientObj.setAddress(patient1.getAddress());
        patientRepository.save(patientObj);
        return patientRepository.findAll();
    }

    @DeleteMapping("/patient/{id}")
    public List<patient> deleteStudent(@PathVariable Integer id) {
        patientRepository.delete(patientRepository.findById(id).get());
        return patientRepository.findAll();
    }
}
