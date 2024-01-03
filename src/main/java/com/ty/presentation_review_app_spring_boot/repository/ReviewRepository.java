package com.ty.presentation_review_app_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.presentation_review_app_spring_boot.dto.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	
	
	

}
