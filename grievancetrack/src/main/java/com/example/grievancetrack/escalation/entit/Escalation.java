package com.example.grievancetrack.escalation.entit;

import com.example.grievancetrack.grievance.entit.Grievance;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "escalations")
public class Escalation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escalationId;

    private LocalDateTime escalatedAt;

    @NotBlank(message = "Officer name is required")
    private String officerName;

    @NotBlank(message = "Reason is required")
    private String reason;

    @NotNull(message = "Grievance is required")
    @ManyToOne
    @JoinColumn(name = "grievance_id")
    private Grievance grievance;

    public Escalation() {
    }

    public Escalation(Long escalationId, LocalDateTime escalatedAt,
                      String officerName, String reason,
                      Grievance grievance) {
        this.escalationId = escalationId;
        this.escalatedAt = escalatedAt;
        this.officerName = officerName;
        this.reason = reason;
        this.grievance = grievance;
    }

    public Long getEscalationId() {
        return escalationId;
    }

    public void setEscalationId(Long escalationId) {
        this.escalationId = escalationId;
    }

    public LocalDateTime getEscalatedAt() {
        return escalatedAt;
    }

    public void setEscalatedAt(LocalDateTime escalatedAt) {
        this.escalatedAt = escalatedAt;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Grievance getGrievance() {
        return grievance;
    }

    public void setGrievance(Grievance grievance) {
        this.grievance = grievance;
    }
}