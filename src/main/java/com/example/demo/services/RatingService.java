package com.example.demo.services;

import com.example.demo.models.Rating;
import com.example.demo.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating){
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating existing = optionalRating.get();
            existing.setScore(updatedRating.getScore());
            existing.setComment(updatedRating.getComment());
            existing.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(existing);
        } else {
            throw new RuntimeException("Rating with ID " + id + " not found.");
        }
    }

    public void deleteRating(String id){
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType){
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore){
        return ratingRepository.findByScoreGreaterThan(minScore);

    }

}
