package com.ty.presentation_review_app_spring_boot.exception;

public class LoginFailedException extends RuntimeException {

	
	String message;
	
	public LoginFailedException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginFailedException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
}

