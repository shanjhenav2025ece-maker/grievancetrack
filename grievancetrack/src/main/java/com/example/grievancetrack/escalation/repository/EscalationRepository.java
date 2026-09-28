package com.example.grievancetrack.escalation.repository;

import com.example.grievancetrack.escalation.entit.Escalation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscalationRepository extends JpaRepository<Escalation, Long> {

}