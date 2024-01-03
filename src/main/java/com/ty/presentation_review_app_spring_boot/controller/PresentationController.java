package com.ty.presentation_review_app_spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<ResponseStructure<Presentation>> startVoting(@PathVariable int pid,@RequestParam double totalTime){
		
		return service.startVotingById(pid,totalTime);
	}
	
	@GetMapping("/complete/{pid}")
	public ResponseEntity<ResponseStructure<Presentation>> completePresentation(@PathVariable int pid){
		
		return service.CompletePresentation(pid);
	}
	
	@GetMapping("/findAll/{uid}")
	public ResponseEntity<ResponseStructure<List<Presentation>>> getAllPresentation(@PathVariable int uid){
		
		return service.findAllPresentation(uid);
	}
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<ResponseStructure<Presentation>> findPresentation(@PathVariable int pid){
		
		return service.findPresentationById(pid);
	}
	
	@GetMapping("/calculate/{pid}")
	public ResponseEntity<ResponseStructure<Presentation>> calculatePresentation(@PathVariable int pid){
		
		return service.calculatePresentationMarks(pid);
	}
}
