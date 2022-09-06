package com.example.repositories;

import com.example.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {
}
