package com.ty.presentation_review_app_spring_boot.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dao.UserDao;
import com.ty.presentation_review_app_spring_boot.dto.Login;
import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.IdNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.LoginFailedException;
import com.ty.presentation_review_app_spring_boot.exception.TrainnerAlreadyExistException;
import com.ty.presentation_review_app_spring_boot.exception.UserEmailNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.UserNameNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.UserRoleNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserDao userDaoObject;
	
	
	public ResponseEntity<ResponseStructure<User>> registerUser(User passedUser)
	{
		
		if(passedUser.getRole().equals(Role.Trainer))
		{
			try {
				User savedUserStatus=userDaoObject.registerUser(passedUser);
				ResponseStructure<User> responseStructure= new ResponseStructure<User>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Success");
				responseStructure.setData(savedUserStatus);
				return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		
			} catch (DataIntegrityViolationException e)
			{

				ResponseStructure<User> responseStructure= new ResponseStructure<User>();
				responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
				responseStructure.setMessage("Cannot register User Already Exist For Email "+passedUser.getEmail());
				return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.BAD_REQUEST);
		
		
			}
			
	
		}
		else
		{
			throw new TrainnerAlreadyExistException();
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
	
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User PassedUser,int id)
	{
		User user=userDaoObject.updateUser(PassedUser,id);
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
	
	
	public ResponseEntity<ResponseStructure<User>> updateUserByName(String name,String email,String password)
	{
		User user=userDaoObject.updateUserByEmail(name,email,password );
		if(user!=null)
		{
			ResponseStructure<User> userResponseStucture= new ResponseStructure<>();
			userResponseStucture.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponseStucture.setMessage("User Successfully Updated");
			userResponseStucture.setData(user);
			
			return new ResponseEntity<ResponseStructure<User>>(userResponseStucture,HttpStatus.OK);
		}
		else
		{
			throw new UserNameNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<User>> updateUserByEmail(String name,String email,String status)
	{
		User user=userDaoObject.updateUserByEmail(name,email,status );
		if(user!=null)
		{
			ResponseStructure<User> userResponseStucture= new ResponseStructure<>();
			userResponseStucture.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponseStucture.setMessage("User Successfully Updated");
			userResponseStucture.setData(user);
			
			return new ResponseEntity<ResponseStructure<User>>(userResponseStucture,HttpStatus.OK);
		}
		else
		{
			throw new UserEmailNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<User>> login(String email,String password)
	{
		User login=userDaoObject.userLogin(email, password);
		
		if(login!=null)
		{
			ResponseStructure<User> userResponseStucture= new ResponseStructure<>();
			userResponseStucture.setStatusCode(HttpStatus.ACCEPTED.value());
			userResponseStucture.setMessage("Login Successfull");
			userResponseStucture.setData(login);
			
			return new ResponseEntity<ResponseStructure<User>>(userResponseStucture,HttpStatus.OK);
		
			
		}
		else
		{
			throw new LoginFailedException("InValidLogin Credentials");
		}
		
	
		
	}
	
	
	
	

	

}
