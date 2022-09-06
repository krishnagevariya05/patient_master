package com.example.controller;

import com.example.model.PatientRecord;
import com.example.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listPatients")
    public List<PatientRecord> getAllPatients() {

        return patientRecordRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public PatientRecord getPatient(@PathVariable Integer id) {
        return patientRecordRepository.findById(id).get();
    }

    @PostMapping("/patient")
    public List<PatientRecord> addPatient(@RequestBody PatientRecord patient) {
        patientRecordRepository.save(patient);
        return patientRecordRepository.findAll();
    }

    @PutMapping("/patients/{id}")
    public List<PatientRecord> updatePatient(@RequestBody PatientRecord patientRecord, @PathVariable Integer id) {
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deleteStudent(@PathVariable Integer id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }
}
