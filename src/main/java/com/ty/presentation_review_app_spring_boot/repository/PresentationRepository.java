package com.ty.presentation_review_app_spring_boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Integer> {

	
		
}
