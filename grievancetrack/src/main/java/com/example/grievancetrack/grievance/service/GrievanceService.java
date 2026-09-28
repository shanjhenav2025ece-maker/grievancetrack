package com.example.grievancetrack.grievance.service;

import com.example.grievancetrack.grievance.entit.Grievance;
import com.example.grievancetrack.grievance.repository.GrievanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GrievanceService {

    private final GrievanceRepository grievanceRepository;

    public GrievanceService(GrievanceRepository grievanceRepository) {
        this.grievanceRepository = grievanceRepository;
    }

    public Grievance createGrievance(Grievance grievance) {

        grievance.setStatus("Pending");
        grievance.setCreatedAt(LocalDateTime.now());

        return grievanceRepository.save(grievance);
    }

    public List<Grievance> getAllGrievances() {
        return grievanceRepository.findAll();
    }

    public Grievance getGrievanceById(Long id) {
        return grievanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grievance not found"));
    }

    public Grievance updateGrievance(Long id, Grievance grievance) {

        Grievance existingGrievance = getGrievanceById(id);

        existingGrievance.setDescription(grievance.getDescription());
        existingGrievance.setLocation(grievance.getLocation());
        existingGrievance.setStatus(grievance.getStatus());
        existingGrievance.setResolvedAt(grievance.getResolvedAt());
        existingGrievance.setCitizen(grievance.getCitizen());
        existingGrievance.setCategory(grievance.getCategory());
        existingGrievance.setDepartment(grievance.getDepartment());

        return grievanceRepository.save(existingGrievance);
    }

    public void deleteGrievance(Long id) {

        Grievance existingGrievance = getGrievanceById(id);

        grievanceRepository.delete(existingGrievance);
    }
}