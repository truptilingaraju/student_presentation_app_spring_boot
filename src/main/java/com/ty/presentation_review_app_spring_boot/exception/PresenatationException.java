package com.ty.presentation_review_app_spring_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.presentation_review_app_spring_boot.dto.ResponseStructure;

@RestControllerAdvice
public class PresenatationException {

	@ExceptionHandler(PresentationIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(PresentationIdNotFoundException exception){
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage(exception.getMessage());
		structure.setData("not found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
