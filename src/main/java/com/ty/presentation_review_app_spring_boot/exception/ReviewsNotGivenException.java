package com.ty.presentation_review_app_spring_boot.exception;

public class ReviewsNotGivenException extends RuntimeException {

private String message;
	
	public ReviewsNotGivenException() {
		// TODO Auto-generated constructor stub
	}
	public ReviewsNotGivenException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
