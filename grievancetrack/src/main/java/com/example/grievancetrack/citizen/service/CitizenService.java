package com.example.grievancetrack.citizen.service;

import com.example.grievancetrack.citizen.entit.Citizen;
import com.example.grievancetrack.citizen.repository.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;

    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    public Citizen createCitizen(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    public Citizen getCitizenById(Long id) {
        return citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));
    }

    public Citizen updateCitizen(Long id, Citizen citizen) {
        Citizen existingCitizen = getCitizenById(id);

        existingCitizen.setName(citizen.getName());
        existingCitizen.setEmail(citizen.getEmail());
        existingCitizen.setPhone(citizen.getPhone());

        return citizenRepository.save(existingCitizen);
    }

    public void deleteCitizen(Long id) {
        Citizen existingCitizen = getCitizenById(id);
        citizenRepository.delete(existingCitizen);
    }
}