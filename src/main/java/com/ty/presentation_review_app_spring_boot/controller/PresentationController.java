package com.ty.presentation_review_app_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.service.PresentationService;

@RestController
public class PresentationController {

	@Autowired
	private PresentationService service;
	
	@PostMapping("/save-presentation")
	public ResponseEntity<ResponseStructure<Presentation>> savePresentation(@RequestBody Presentation presentation){
		
		return service.save(presentation);
	}
	
	@GetMapping("/get-presentation/{id}")
	public ResponseEntity<ResponseStructure<Presentation>> getPresentation(@PathVariable int id){
		
		return service.findById(id);
	}
}
