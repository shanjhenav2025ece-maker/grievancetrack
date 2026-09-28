package com.example.grievancetrack.escalation.controller;

import com.example.grievancetrack.escalation.entit.Escalation;
import com.example.grievancetrack.escalation.service.EscalationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escalations")
public class EscalationController {

    private final EscalationService escalationService;

    public EscalationController(EscalationService escalationService) {
        this.escalationService = escalationService;
    }

    @PostMapping
    public ResponseEntity<Escalation> createEscalation(
            @Valid @RequestBody Escalation escalation) {

        return new ResponseEntity<>(
                escalationService.createEscalation(escalation),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Escalation>> getAllEscalations() {
        return ResponseEntity.ok(
                escalationService.getAllEscalations()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escalation> getEscalationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                escalationService.getEscalationById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escalation> updateEscalation(
            @PathVariable Long id,
            @Valid @RequestBody Escalation escalation) {

        return ResponseEntity.ok(
                escalationService.updateEscalation(id, escalation)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEscalation(
            @PathVariable Long id) {

        escalationService.deleteEscalation(id);

        return ResponseEntity.ok(
                "Escalation deleted successfully"
        );
    }
}