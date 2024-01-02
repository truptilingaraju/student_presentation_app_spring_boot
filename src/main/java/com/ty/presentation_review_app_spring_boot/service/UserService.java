package com.ty.presentation_review_app_spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dao.UserDao;
import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.IdNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.UserNameNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.UserRoleNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserDao userDaoObject;
	
	
	public ResponseEntity<ResponseStructure<User>> registerUser(User passedUser)
	{
		
		try {
			User savedUserStatus=userDaoObject.registerUser(passedUser);
			ResponseStructure<User> responseStructure= new ResponseStructure<User>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(savedUserStatus);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
			
		} catch (DataIntegrityViolationException e) {

			ResponseStructure<User> responseStructure= new ResponseStructure<User>();
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMessage("Cannot register User Already Exist For Email "+passedUser.getEmail());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
			
			
			
			
		}
		
		
		
		

		
	}
	
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id)
	{
		User user=userDaoObject.getUserById(id);
		
		if(user!=null)
		{
			ResponseStructure<User> userResponseStructure= new ResponseStructure<User>();
			userResponseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponseStructure.setMessage("Success");
			userResponseStructure.setData(user);
			
			return new ResponseEntity<ResponseStructure<User>>(userResponseStructure,HttpStatus.OK);
		}
		else
		{
			
			throw new IdNotFoundException("Id Not Exist for Id "+id);
		}
	}
	
	
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id)
	{
		
		boolean userDeletedStatus=userDaoObject.deleteUserById(id);
		
		if(userDeletedStatus)
		{
			ResponseStructure<String> userResponse= new ResponseStructure<String>();
			userResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponse.setMessage("Success");
			userResponse.setData("User Deleted Successfully");
			return new ResponseEntity<ResponseStructure<String>>(userResponse,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException("Use Not Exist For Id : "+id);
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User PassedUser)
	{
		User user=userDaoObject.updateUser(PassedUser);
		if(user!=null)
		{
			ResponseStructure<User> userResponse= new ResponseStructure<User>();
			userResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponse.setMessage("Success");
			userResponse.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(userResponse,HttpStatus.OK);
		
		}
		else
		{
			throw new IdNotFoundException("Use Not Exist For Id : "+PassedUser.getId());
		}
	}
	
	
	public ResponseEntity<ResponseStructure<List<User>>> getUserByRole(Role role)
	{
		
		if(role.equals(Role.Student)|| role.equals(Role.Trainer))
		{
		List<User> userList=userDaoObject.getUserByRole(role);
		
		if(!userList.isEmpty())
		{

			ResponseStructure<List<User>> userResponse= new ResponseStructure<List<User>>();
			userResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponse.setMessage("Success");
			userResponse.setData(userList);
			
			return new ResponseEntity<ResponseStructure<List<User>>>(userResponse,HttpStatus.OK);
		}
		else
		{
			throw new UserRoleNotFoundException("User Does Not Exist For Role :"+role);
		}
		
		}
		else
		{
			throw new UserRoleNotFoundException("User Does Not Exist For Role :"+role);
		}
		
		
		
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getUserByName(String name)
	{
		
		List<User> userList=userDaoObject.getUserByName(name);
		
		if(userList!=null)
		{
			ResponseStructure<List<User>> userResponseStructure= new ResponseStructure<List<User>>();
			userResponseStructure.setMessage("Success");
			userResponseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponseStructure.setData(userList);
			
			return new ResponseEntity<ResponseStructure<List<User>>>(userResponseStructure,HttpStatus.OK);
			
		}	
		else
		{
			throw new UserNameNotFoundException();
		}
	}
	
	
	public void updateUserByName(String name,String email,String status)
	{
		
	}

	
	
	
	
	
	

	

}
