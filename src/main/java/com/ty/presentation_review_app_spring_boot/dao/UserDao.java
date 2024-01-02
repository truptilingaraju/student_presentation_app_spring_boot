package com.ty.presentation_review_app_spring_boot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.repository.UserRepository;

@Repository
public class UserDao {

	
	@Autowired
	UserRepository userRepository;
	
	
	public User registerUser(User passedUser)
	{
		userRepository.save(passedUser);
		return passedUser;
	}
	
	public User getUserById(int passedUserId)
	{
		Optional<User> user=userRepository.findById(passedUserId);
		
		if(user.isPresent())
		{

		  User userWithData=user.get();
			
		  return userWithData;
		}
		return null;

	}
	
	public boolean deleteUserById(int passedUserId)
	{

		Optional<User> user=userRepository.findById(passedUserId);
		
		if(user.isPresent())
		{
			userRepository.deleteById(passedUserId);
			return true;
		}
		return false;
		
	}
	
	public User updateUser(User passedUser)
	{
		Optional<User> user=userRepository.findById(passedUser.getId());
		
		if(user.isPresent())
		{
			userRepository.save(passedUser);

			return passedUser;
		}
		return null;
		
		
	}
	
	
	public List<User> getUserByRole(Role role)
	{
		List<User> userList=userRepository.findUserByRole(role);
		return userList;
	}
	
	public List<User> getUserByName(String name)
	{
		List<User> userList=userRepository.findUserByName(name);
		
		return userList;
	}
	
	public User updateUserByName(String name,String status,String email)
	{
		User userInfo=userRepository.updateUserByName(status, email, name);
		return userInfo;
		
	}



}
