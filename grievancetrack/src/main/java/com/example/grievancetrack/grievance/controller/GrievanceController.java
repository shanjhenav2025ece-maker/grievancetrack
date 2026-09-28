package com.example.grievancetrack.grievance.controller;

import com.example.grievancetrack.grievance.entit.Grievance;
import com.example.grievancetrack.grievance.service.GrievanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    private final GrievanceService grievanceService;

    public GrievanceController(GrievanceService grievanceService) {
        this.grievanceService = grievanceService;
    }

    @PostMapping
    public ResponseEntity<Grievance> createGrievance(
            @Valid @RequestBody Grievance grievance) {

        return new ResponseEntity<>(
                grievanceService.createGrievance(grievance),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        return ResponseEntity.ok(
                grievanceService.getAllGrievances()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grievance> getGrievanceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                grievanceService.getGrievanceById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grievance> updateGrievance(
            @PathVariable Long id,
            @Valid @RequestBody Grievance grievance) {

        return ResponseEntity.ok(
                grievanceService.updateGrievance(id, grievance)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrievance(
            @PathVariable Long id) {

        grievanceService.deleteGrievance(id);

        return ResponseEntity.ok(
                "Grievance deleted successfully"
        );
    }
}