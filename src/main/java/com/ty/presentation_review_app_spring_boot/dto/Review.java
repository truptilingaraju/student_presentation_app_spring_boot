package com.ty.presentation_review_app_spring_boot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int confidence;
	
	private int communication;
	
	private int interaction;
	
	private int eyeContact;
	
	private String content;
	
	private int liveliness;
	
	private int energy;
	
	@OneToOne
	private User votes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getInteraction() {
		return interaction;
	}

	public void setInteraction(int interaction) {
		this.interaction = interaction;
	}

	public int getEyeContact() {
		return eyeContact;
	}

	public void setEyeContact(int eyeContact) {
		this.eyeContact = eyeContact;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLiveliness() {
		return liveliness;
	}

	public void setLiveliness(int liveliness) {
		this.liveliness = liveliness;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public User getVotes() {
		return votes;
	}

	public void setVotes(User votes) {
		this.votes = votes;
	}

	public Review(int id, int confidence, int communication, int interaction, int eyeContact, String content,
			int liveliness, int energy, User votes) {
		
		this.id = id;
		this.confidence = confidence;
		this.communication = communication;
		this.interaction = interaction;
		this.eyeContact = eyeContact;
		this.content = content;
		this.liveliness = liveliness;
		this.energy = energy;
		this.votes = votes;
	}
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
