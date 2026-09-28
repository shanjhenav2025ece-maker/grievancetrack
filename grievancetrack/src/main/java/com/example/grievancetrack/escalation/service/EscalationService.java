package com.example.grievancetrack.escalation.service;

import com.example.grievancetrack.escalation.entit.Escalation;
import com.example.grievancetrack.escalation.repository.EscalationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EscalationService {

    private final EscalationRepository escalationRepository;

    public EscalationService(EscalationRepository escalationRepository) {
        this.escalationRepository = escalationRepository;
    }

    public Escalation createEscalation(Escalation escalation) {

        escalation.setEscalatedAt(LocalDateTime.now());

        return escalationRepository.save(escalation);
    }

    public List<Escalation> getAllEscalations() {
        return escalationRepository.findAll();
    }

    public Escalation getEscalationById(Long id) {
        return escalationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escalation not found"));
    }

    public Escalation updateEscalation(Long id, Escalation escalation) {

        Escalation existingEscalation = getEscalationById(id);

        existingEscalation.setOfficerName(escalation.getOfficerName());
        existingEscalation.setReason(escalation.getReason());
        existingEscalation.setGrievance(escalation.getGrievance());

        return escalationRepository.save(existingEscalation);
    }

    public void deleteEscalation(Long id) {

        Escalation existingEscalation = getEscalationById(id);

        escalationRepository.delete(existingEscalation);
    }
}