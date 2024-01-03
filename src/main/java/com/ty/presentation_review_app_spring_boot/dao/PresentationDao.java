package com.ty.presentation_review_app_spring_boot.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.PresentationStatus;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.IdNotFoundException;
import com.ty.presentation_review_app_spring_boot.repository.PresentationRepository;

@Repository
public class PresentationDao {

	@Autowired
	private PresentationRepository pRepository;
	
	public Presentation savePresentation(Presentation presentation) {
		
		return pRepository.save(presentation);
		
	}
	
	public Presentation upadtePresentation(Presentation presentation) {
		return pRepository.save(presentation);
	}
	
	public Presentation findPresentationById(int id) {
		
		Optional<Presentation> optional=pRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else
			return null;
		
	}
	
	public List<Presentation> getAll(int uid){
		
		return pRepository.getAllPresentation(uid);
	}
}
