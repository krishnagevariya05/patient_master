package com.example.repositories;

import com.example.model.patient;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRecordRepository extends JpaRepository<patient, Integer> {
}
