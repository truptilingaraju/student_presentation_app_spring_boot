package com.ty.presentation_review_app_spring_boot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;

public interface PresentationRepository extends JpaRepository<Presentation, Integer> {

	@Query("select p from Presentation p where p.presentor.id=?1")
	public List<Presentation> getAllPresentation(int uid);
		
}
