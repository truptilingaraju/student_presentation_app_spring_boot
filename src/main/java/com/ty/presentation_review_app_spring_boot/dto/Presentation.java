package com.ty.presentation_review_app_spring_boot.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String topic;
	private String subject;
	private Status status;
	private double totalMarks;
	@CreationTimestamp
	private LocalDateTime startedTime;
	private double totalTime;
	@OneToMany
	private List<Review> reviews;
	@ManyToOne
	@JoinColumn(name="presentor_id")
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}
	public LocalDateTime getStartedTime() {
		return startedTime;
	}
	public void setStartedTime(LocalDateTime startedTime) {
		this.startedTime = startedTime;
	}
	public double getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
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
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
