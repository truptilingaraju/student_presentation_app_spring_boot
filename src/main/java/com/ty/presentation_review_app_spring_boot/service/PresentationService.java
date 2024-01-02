package com.ty.presentation_review_app_spring_boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dao.PresentationDao;
import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.PresentationIdNotFoundException;

@Service
public class PresentationService {

	@Autowired
	private PresentationDao presentationDao;
	
	public ResponseEntity<ResponseStructure<Presentation>> save(Presentation  presentation,int id){
		
		}
	
	
	
}
