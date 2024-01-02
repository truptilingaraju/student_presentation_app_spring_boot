package com.ty.presentation_review_app_spring_boot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int confidence;
	private int communication;
	private int interaction;
	private int eyecontact;
	private int content;
	private int liveliness;
	private int energy;
	
	@OneToOne
	private User voter;

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

	public int getEyecontact() {
		return eyecontact;
	}

	public void setEyecontact(int eyecontact) {
		this.eyecontact = eyecontact;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
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

	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
