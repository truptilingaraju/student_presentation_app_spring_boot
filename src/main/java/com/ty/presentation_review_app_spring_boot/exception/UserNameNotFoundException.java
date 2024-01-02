package com.ty.presentation_review_app_spring_boot.exception;

public class UserNameNotFoundException extends RuntimeException {
	
	String message;
	
	
	public UserNameNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNameNotFoundException(String message) {
		
		this.message=message;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	

}
