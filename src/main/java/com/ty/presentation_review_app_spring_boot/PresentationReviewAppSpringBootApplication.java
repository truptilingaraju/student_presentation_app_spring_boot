package com.ty.presentation_review_app_spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ty.presentation_review_app_spring_boot.dto.Role;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.dto.UserStatus;
import com.ty.presentation_review_app_spring_boot.repository.UserRepository;
import com.ty.presentation_review_app_spring_boot.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PresentationReviewAppSpringBootApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	User user;

	public static void main(String[] args) {
		SpringApplication.run(PresentationReviewAppSpringBootApplication.class, args);
	}

	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub

		List<User> userList = userRepository.findUserByRole(Role.Trainer);

		if (userList.isEmpty()) {
			user.setEmail("shiv@gmail.com");
			user.setName("Shiv");
			user.setPassword("shiv@123");
			user.setPhone(123456789);
			user.setRole(Role.Trainer);
			user.setStatus(UserStatus.Active);

			userService.registerUser(user);
			System.out.println("Trainner Created Successfully");
		} else {

			System.out.println("Trainner Already Exist");
		}

	}
}
