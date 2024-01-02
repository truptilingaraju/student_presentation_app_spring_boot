package com.ty.presentation_review_app_spring_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dto.User;

@RestControllerAdvice
public class UserException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFoundException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("User Not Found");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserRoleNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserRoleNot(UserRoleNotFoundException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("User does Not Exist for Role");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
		
	}
	
}
