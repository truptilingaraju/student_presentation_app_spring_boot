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
	
	@ExceptionHandler(UserEmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserNameNotFoundException(UserRoleNotFoundException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("User Name Not Exist");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserEmailNotFoundException(UserRoleNotFoundException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("User Email Not Exist");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<ResponseStructure<String>> loginFailedException(LoginFailedException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Invalid User Credentials");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	

	@ExceptionHandler(TrainnerAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> trainerAlredyExcistException(TrainnerAlreadyExistException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Trainner Already Exist");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(UnauthorizedSelfReviewException.class)
	public ResponseEntity<ResponseStructure<String>> UnauthorizedSelfReviewException(UnauthorizedSelfReviewException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Presentor Can not Give Review");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(PresentationIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> presentationIdNotFoundException(PresentationIdNotFoundException exception)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Presentation Id Not Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(VotingClosedException.class)
	public ResponseEntity<ResponseStructure<String>> votingClosedException(VotingClosedException exception)
	{
		
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Voting Already Closed");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PresentationIsInAssignedStateException.class)
	public ResponseEntity<ResponseStructure<String>> presentationIsInAssignedState(PresentationIsInAssignedStateException exception)
	{
		
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setData("Voting Not Started Yet");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
}
