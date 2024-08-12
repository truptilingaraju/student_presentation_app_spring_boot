package com.ty.presentation_review_app_spring_boot.exception;

public class UserNameNotFoundException extends RuntimeException {
	

	String message;
	
	public UserNameNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserNameNotFoundException(String message) {
	
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
