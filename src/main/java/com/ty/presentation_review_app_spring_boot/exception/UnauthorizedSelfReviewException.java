package com.ty.presentation_review_app_spring_boot.exception;

public class UnauthorizedSelfReviewException extends RuntimeException {
	
	
	String message;
	
	public UnauthorizedSelfReviewException() {
		// TODO Auto-generated constructor stub
	}

	
	public UnauthorizedSelfReviewException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		
		return message;
	}
	
}
