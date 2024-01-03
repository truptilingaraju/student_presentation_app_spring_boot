package com.ty.presentation_review_app_spring_boot.dao;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;



import com.ty.presentation_review_app_spring_boot.exception.IdNotFoundException;

import com.ty.presentation_review_app_spring_boot.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User registerUser(User passedUser) {
		userRepository.save(passedUser);
		return passedUser;
	}

	public User getUserById(int passedUserId) {
		Optional<User> user = userRepository.findById(passedUserId);

		if (user.isPresent()) {

			User userWithData = user.get();

			return userWithData;
		}
		return null;

	}

	public boolean deleteUserById(int passedUserId) {

		Optional<User> user = userRepository.findById(passedUserId);

		if (user.isPresent()) {
			userRepository.deleteById(passedUserId);
			return true;
		}
		return false;

	}


	

	
	public User updateUser(User passedUser,int id)
	{
		Optional<User> user=userRepository.findById(id);
		
		if(user.isPresent())
		{
			passedUser.setId(id);
			

			userRepository.save(passedUser);

			return passedUser;
		}

		else
		{
			throw new IdNotFoundException("User Not Exist");
		}
		

	}

	public List<User> getUserByRole(Role role) {
		List<User> userList = userRepository.findUserByRole(role);
		return userList;
	}

	public List<User> getUserByName(String name) {
		List<User> userList = userRepository.findUserByName(name);

		return userList;
	}


	
	public User updateUserByEmail(String name,String email,String status)
	{
			User userInfo=userRepository.getUserByEmail(email);
		
		
			userInfo.setName(name);
			
			userInfo.setRole(Role.Student);
			
			userRepository.save(userInfo);
           		
		
			return userInfo;
		
	}

	
	public User userLogin(String email,String password)
	{
		User userInfo=userRepository.userLogin(email, password);
		return userInfo;
	}


	

}
