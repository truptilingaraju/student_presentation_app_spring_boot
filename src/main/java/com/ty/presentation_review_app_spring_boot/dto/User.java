package com.ty.presentation_review_app_spring_boot.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "userinfo")
@Component
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(unique =true)
	private String email;
	
	private long phone;
	
	private String password;
	
	private UserStatus status;
	
	private Role role;
	
	@OneToMany(mappedBy = "presentor")
	List<Presentation> presentationList;


	
	public User() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserStatus getStatus() {
		return status;
	}



	public void setStatus(UserStatus status) {
		this.status = status;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public List<Presentation> getPresentationList() {
		return presentationList;
	}



	public void setPresentationList(List<Presentation> presentationList) {
		this.presentationList = presentationList;
	}



	public User(int id, String name, String email, long phone, String password, UserStatus status, Role role,
			List<Presentation> presentationList) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.role = role;
		this.presentationList = presentationList;
	}
	
	

	
	
}
