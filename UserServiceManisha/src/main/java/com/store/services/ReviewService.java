package com.store.services;

import java.util.List;

import com.store.entity.Review;


public interface ReviewService {
	
	 public Review addReview(Review review);
	 public List<Review> getReviewsByApplication(Long appId);
	 public Review updateReview(Long reviewId, Review updatedReview);
	 public void deleteReview(Long reviewId);
}
