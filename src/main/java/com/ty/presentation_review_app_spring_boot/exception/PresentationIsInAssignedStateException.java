package com.ty.presentation_review_app_spring_boot.exception;

public class PresentationIsInAssignedStateException extends RuntimeException {
	
	String message;
	
	public PresentationIsInAssignedStateException() {
		// TODO Auto-generated constructor stub
	}
	
	public PresentationIsInAssignedStateException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
