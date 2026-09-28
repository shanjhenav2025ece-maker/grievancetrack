package com.example.grievancetrack.grievance.repository;

import com.example.grievancetrack.grievance.entit.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrievanceRepository extends JpaRepository<Grievance, Long> {

}