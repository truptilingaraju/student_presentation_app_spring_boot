package com.ty.presentation_review_app_spring_boot.exception;

public class UserEmailNotFoundException extends RuntimeException {
	
	String message;
	
	
	public UserEmailNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEmailNotFoundException(String message) {
		
		this.message=message;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	

}
