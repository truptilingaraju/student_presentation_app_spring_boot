package com.ty.presentation_review_app_spring_boot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int communication;
	
	int confidence;
	
	String content;
	
	int energy;
	
	int eye_contact;
	
	int interaction;
	
	int liveliness;
	
	int votes_id;
		

}
