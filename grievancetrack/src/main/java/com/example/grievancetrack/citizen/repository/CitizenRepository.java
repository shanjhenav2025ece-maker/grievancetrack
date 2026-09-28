package com.example.grievancetrack.citizen.repository;

import com.example.grievancetrack.citizen.entit.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

}