package com.ty.presentation_review_app_spring_boot.exception;

public class VotingClosedException extends RuntimeException {
	

	String message;
	
	public VotingClosedException() {
		// TODO Auto-generated constructor stub
	}
	
	public VotingClosedException(String message) {
	
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
