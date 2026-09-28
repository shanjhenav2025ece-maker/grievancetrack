package com.example.grievancetrack.resolutionrating.service;

import com.example.grievancetrack.resolutionrating.entit.ResolutionRating;
import com.example.grievancetrack.resolutionrating.repository.ResolutionRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResolutionRatingService {

    private final ResolutionRatingRepository ratingRepository;

    public ResolutionRatingService(ResolutionRatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public ResolutionRating createRating(ResolutionRating rating) {
        return ratingRepository.save(rating);
    }

    public List<ResolutionRating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public ResolutionRating getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resolution rating not found"));
    }

    public ResolutionRating updateRating(Long id, ResolutionRating rating) {

        ResolutionRating existingRating = getRatingById(id);

        existingRating.setScore(rating.getScore());
        existingRating.setFeedback(rating.getFeedback());
        existingRating.setGrievance(rating.getGrievance());

        return ratingRepository.save(existingRating);
    }

    public void deleteRating(Long id) {

        ResolutionRating existingRating = getRatingById(id);

        ratingRepository.delete(existingRating);
    }
}