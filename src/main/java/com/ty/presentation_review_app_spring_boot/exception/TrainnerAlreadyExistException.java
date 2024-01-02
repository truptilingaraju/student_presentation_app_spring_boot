package com.ty.presentation_review_app_spring_boot.exception;

public class TrainnerAlreadyExistException extends RuntimeException{

	
	String message;
	
	public TrainnerAlreadyExistException() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TrainnerAlreadyExistException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
