package com.ty.presentation_review_app_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.role=?1")
	List<User> findUserByRole(Role role);
	

	@Query("select u from User u where u.name=?1")
	List<User> findUserByName(String name);
	
	@Query("update User u set u.status=? and u.email=? where u.name=?")
	User updateUserByName(String status,String email,String name);
	
	
	
	
}

