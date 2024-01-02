package com.ty.presentation_review_app_spring_boot.exception;

public class UserRoleNotFoundException extends RuntimeException {

	String message;
	
	public UserRoleNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoleNotFoundException(String message) {
	
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
