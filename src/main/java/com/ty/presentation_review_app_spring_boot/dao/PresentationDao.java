package com.ty.presentation_review_app_spring_boot.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.repository.PresentationRepository;

@Repository
public class PresentationDao {

	@Autowired
	private PresentationRepository repository;
	
	public Presentation savePresentation(Presentation presentation) {
		return repository.save(presentation);
	}
	
	
	
}
