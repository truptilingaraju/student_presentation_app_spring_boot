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
	
	@PostMapping("/save-presentation/{uid}")
	public ResponseEntity<ResponseStructure<Presentation>> savePresentation(@RequestBody Presentation presentation, @PathVariable int uid){
		
		return service.savePresentation(presentation, uid);
	}
	@GetMapping("/voting/{pid}")
	public ResponseEntity<ResponseStructure<Presentation>> startVoting(@PathVariable int pid){
		
		return service.startVoting(pid);
	}
	
	@GetMapping("/complete/{pid}")
	public ResponseEntity<ResponseStructure<Presentation>> completePresentation(@PathVariable int pid){
		
		return service.CompletePresentation(pid);
	}
}
