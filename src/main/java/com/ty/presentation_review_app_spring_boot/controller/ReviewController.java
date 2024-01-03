package com.ty.presentation_review_app_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dto.Review;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/saveReview/{presentationId}/{ReviewerId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review passedReview,
			@PathVariable int presentationId, @PathVariable int ReviewerId) {
		return reviewService.saveReview(passedReview, presentationId, ReviewerId);
	}

}
