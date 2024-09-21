package com.store.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.entity.Review;
import com.store.repository.ReviewRepository;
import com.store.services.ReviewService;



@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {
        review.setReviewDate(new Date()); // Set the review date to the current date
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByApplication(Long appId) {
        return reviewRepository.findByApplicationAppId(appId); // Retrieves all reviews for a specific application
    }

    @Override
    public Review updateReview(Long reviewId, Review updatedReview) {
        // Find the existing review by ID or throw an exception if not found
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        
        review.setComment(updatedReview.getComment());
        review.setRating(updatedReview.getRating());
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId) {
    	reviewRepository.deleteById(reviewId);
    }
}
