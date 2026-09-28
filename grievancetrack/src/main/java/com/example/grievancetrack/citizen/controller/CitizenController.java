package com.example.grievancetrack.citizen.controller;

import com.example.grievancetrack.citizen.entit.Citizen;
import com.example.grievancetrack.citizen.service.CitizenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @PostMapping
    public ResponseEntity<Citizen> createCitizen(
            @Valid @RequestBody Citizen citizen) {

        return new ResponseEntity<>(
                citizenService.createCitizen(citizen),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        return ResponseEntity.ok(citizenService.getAllCitizens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citizen> getCitizenById(@PathVariable Long id) {
        return ResponseEntity.ok(citizenService.getCitizenById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Citizen> updateCitizen(
            @PathVariable Long id,
            @Valid @RequestBody Citizen citizen) {

        return ResponseEntity.ok(
                citizenService.updateCitizen(id, citizen)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCitizen(@PathVariable Long id) {

        citizenService.deleteCitizen(id);

        return ResponseEntity.ok("Citizen deleted successfully");
    }
}