package com.ty.presentation_review_app_spring_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dto.Review;
import com.ty.presentation_review_app_spring_boot.repository.ReviewRepository;

@Service
public class ReviewDao {
	
	
	@Autowired
	ReviewRepository reviewRepository;
	
	
	public Review SaveReview(Review passedReview)
	{
		reviewRepository.save(passedReview);
		return passedReview;
	}
	
	
	public Optional<Review> getReviewById(int reviewId)
	{
		Optional<Review> reviewDetails=reviewRepository.findById(reviewId);
		return reviewDetails;
	}
	
	

}
