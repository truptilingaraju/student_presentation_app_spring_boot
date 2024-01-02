package com.ty.presentation_review_app_spring_boot.exception;

public class PresentationIdNotFoundException extends RuntimeException {

	
	private String message;
	
	public PresentationIdNotFoundException() {
		
	}
	
	public PresentationIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
