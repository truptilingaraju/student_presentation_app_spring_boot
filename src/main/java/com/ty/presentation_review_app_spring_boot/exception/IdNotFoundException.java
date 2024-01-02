package com.ty.presentation_review_app_spring_boot.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;



public class IdNotFoundException extends RuntimeException {
	
	private String message;
	
	public IdNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public IdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
}
