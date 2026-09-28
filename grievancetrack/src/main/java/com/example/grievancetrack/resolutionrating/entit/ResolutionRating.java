package com.example.grievancetrack.resolutionrating.entit;

import com.example.grievancetrack.grievance.entit.Grievance;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "resolution_ratings")
public class ResolutionRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @NotNull(message = "Score is required")
    @Min(value = 1, message = "Score must be at least 1")
    @Max(value = 5, message = "Score must not exceed 5")
    private Integer score;

    private String feedback;

    @NotNull(message = "Grievance is required")
    @OneToOne
    @JoinColumn(name = "grievance_id")
    private Grievance grievance;

    public ResolutionRating() {
    }

    public ResolutionRating(Long ratingId, Integer score,
                            String feedback, Grievance grievance) {
        this.ratingId = ratingId;
        this.score = score;
        this.feedback = feedback;
        this.grievance = grievance;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Grievance getGrievance() {
        return grievance;
    }

    public void setGrievance(Grievance grievance) {
        this.grievance = grievance;
    }
}