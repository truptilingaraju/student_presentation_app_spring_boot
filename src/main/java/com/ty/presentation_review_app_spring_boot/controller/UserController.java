package com.ty.presentation_review_app_spring_boot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.dto.UserStatus;
import com.ty.presentation_review_app_spring_boot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User passedUser)
	{
		Role role=passedUser.getRole();

		passedUser.setRole(role);
		
		UserStatus status=passedUser.getStatus();
		passedUser.setStatus(status);
		
		return userService.registerUser(passedUser);
	}
	
	
	@GetMapping("/getUserById/{passedId}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int passedId)
	{
		
		return userService.getUserById(passedId);	
	}
	
	
	@DeleteMapping("deleteUserById/{passedId}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(@PathVariable int passedId)
	{
		return userService.deleteUserById(passedId);
	}
	
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User passedUser,@PathVariable int id)
	{
		return userService.updateUser(passedUser,id);
	}
	
	
	@GetMapping("/getUserByRole/{role}")
	public ResponseEntity<ResponseStructure<List<User>>> getUserByRole(@PathVariable Role role)
	{
		return userService.getUserByRole(role);
	}
	
	
	@PutMapping("updateUserByName/{name}/{email}/{status}")
	public ResponseEntity<ResponseStructure<User>> updateUserByName(@PathVariable String  name, @PathVariable String email, @PathVariable String status )
	{
		return userService.updateUserByName(name, email, status);
		
	}
	
	@PutMapping("updateUserByEmail/{name}/{email}/{status}")
	public ResponseEntity<ResponseStructure<User>> updateUserByEmail(@PathVariable String  name, @PathVariable String email, @PathVariable String status )
	{
		return userService.updateUserByEmail(name, email, status);
		
	}
	
	@PostMapping("login/{email}/{password}")
	public ResponseEntity<ResponseStructure<User>> userlogin(@PathVariable String email,@PathVariable String password)
	{
		return userService.login(email, password);
	}
	

	
	

}
