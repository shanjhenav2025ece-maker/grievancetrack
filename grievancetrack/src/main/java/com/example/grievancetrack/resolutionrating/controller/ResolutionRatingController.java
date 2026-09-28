package com.example.grievancetrack.resolutionrating.controller;

import com.example.grievancetrack.resolutionrating.entit.ResolutionRating;
import com.example.grievancetrack.resolutionrating.service.ResolutionRatingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class ResolutionRatingController {

    private final ResolutionRatingService ratingService;

    public ResolutionRatingController(ResolutionRatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<ResolutionRating> createRating(
            @Valid @RequestBody ResolutionRating rating) {

        return new ResponseEntity<>(
                ratingService.createRating(rating),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<ResolutionRating>> getAllRatings() {
        return ResponseEntity.ok(
                ratingService.getAllRatings()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResolutionRating> getRatingById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                ratingService.getRatingById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResolutionRating> updateRating(
            @PathVariable Long id,
            @Valid @RequestBody ResolutionRating rating) {

        return ResponseEntity.ok(
                ratingService.updateRating(id, rating)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(
            @PathVariable Long id) {

        ratingService.deleteRating(id);

        return ResponseEntity.ok(
                "Resolution rating deleted successfully"
        );
    }
}