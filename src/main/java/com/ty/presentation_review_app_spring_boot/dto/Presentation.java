package com.ty.presentation_review_app_spring_boot.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "presentation")
public class Presentation {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String topic;
	
	private String subject;
	
	private LocalDateTime startedTime;
	
	private double totalMarks;
	
	private double totalTime;
	
	private PresentationStatus status;
	
	@OneToMany
	private List<Review> reviews;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User presentor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDateTime getStartedTime() {
		return startedTime;
	}

	public void setStartedTime(LocalDateTime startedTime) {
		this.startedTime = startedTime;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public PresentationStatus getStatus() {
		return status;
	}

	public void setStatus(PresentationStatus status) {
		this.status = status;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public User getPresentor() {
		return presentor;
	}

	public void setPresentor(User presentor) {
		this.presentor = presentor;
	}

	
	public Presentation() {
		// TODO Auto-generated constructor stub
	}

	public Presentation(int id, String topic, String subject, LocalDateTime startedTime, double totalMarks,
			double totalTime, PresentationStatus status, List<Review> reviews, User presentor) {
		this.id = id;
		this.topic = topic;
		this.subject = subject;
		this.startedTime = startedTime;
		this.totalMarks = totalMarks;
		this.totalTime = totalTime;
		this.status = status;
		this.reviews = reviews;
		this.presentor = presentor;
	}
	
	
	
	
	
	
	

}
