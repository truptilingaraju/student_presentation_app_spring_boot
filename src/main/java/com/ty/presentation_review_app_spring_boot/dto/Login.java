package com.ty.presentation_review_app_spring_boot.dto;

public class Login {
	
	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	

}
