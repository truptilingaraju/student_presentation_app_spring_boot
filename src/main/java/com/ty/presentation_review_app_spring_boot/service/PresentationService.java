package com.ty.presentation_review_app_spring_boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dao.PresentationDao;
import com.ty.presentation_review_app_spring_boot.dao.UserDao;
import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.PresentationStatus;
import com.ty.presentation_review_app_spring_boot.dto.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dto.Review;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.IdNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.PresentationIdNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.ReviewsNotGivenException;

@Service
public class PresentationService {

	@Autowired
	private PresentationDao presentationDao;

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Presentation>> savePresentation(Presentation presentation, int id) {

		User user = userDao.getUserById(id);

		if (user != null) {

			presentation.setPresentor(user);
			Presentation recievedpresentation = presentationDao.savePresentation(presentation);

			List<Presentation> presentations = user.getPresentationList();
			if (presentations == null) {
				presentations = new ArrayList<>();
			}
			presentations.add(recievedpresentation);
			user.setPresentationList(presentations);
			userDao.updateUser(user, id);

			ResponseStructure<Presentation> structure = new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("presentation created successfully");
			structure.setData(recievedpresentation);

			return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.CREATED);

		} else {
			throw new IdNotFoundException("invalid id: " + id);
		}

	}
	
	public ResponseEntity<ResponseStructure<Presentation>> startVoting(int pid) {

		Presentation presentation = presentationDao.findPresentationById(pid);

		ResponseStructure<Presentation> structure = new ResponseStructure<>();

		if (presentation != null) {
			PresentationStatus presentationStatus = presentation.getStatus();
			if (presentationStatus == PresentationStatus.Assigned) {
				presentation.setStatus(PresentationStatus.VotingPollOn);
				Presentation presentation2 = presentationDao.upadtePresentation(presentation);

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("voting poll on");
				structure.setData(presentation2);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			} else if (presentationStatus == PresentationStatus.VotingPollOn) {

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("voting is already taking place");
				structure.setData(presentation);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			}

			else {

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("presentation is already completed");
				structure.setData(presentation);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			}

		} else {
			throw new PresentationIdNotFoundException("invalid presentation id: " + pid);
		}

	}

	public ResponseEntity<ResponseStructure<Presentation>> CompletePresentation(int pid) {
		Presentation presentation = presentationDao.findPresentationById(pid);

		ResponseStructure<Presentation> structure = new ResponseStructure<>();

		if (presentation != null) {
			PresentationStatus presentationStatus = presentation.getStatus();
			if (presentationStatus == PresentationStatus.Assigned) {

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("start voting poll on to complete the presentation");
				structure.setData(presentation);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			}

			else if (presentationStatus == PresentationStatus.VotingPollOn) {

				presentation.setStatus(PresentationStatus.Completed);
				Presentation presentation2 = presentationDao.upadtePresentation(presentation);

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("voting is done and its completed");
				structure.setData(presentation);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			}

			else {

				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("presentation is already completed");
				structure.setData(presentation);

				return new ResponseEntity<ResponseStructure<Presentation>>(structure, HttpStatus.ACCEPTED);
			}

		} else {
			throw new PresentationIdNotFoundException("invalid presentation id: " + pid);
		}


	}
	
	
	public ResponseEntity<ResponseStructure<List<Presentation>>> findAllPresentation(int uid){
		
		List<Presentation> presentations=presentationDao.getAll(uid);
		if(presentations.size()>0)
		{
			
			ResponseStructure<List<Presentation>> structure =new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("data fetched successfully");
			structure.setData(presentations);
			
			return new ResponseEntity<ResponseStructure<List<Presentation>>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("invalid user id: " + uid);
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Presentation>> findPresentationById(int pid){
		
		Presentation presentation=presentationDao.findPresentationById(pid);
		
		if(presentation!=null) {
			ResponseStructure<Presentation> structure =new ResponseStructure<>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("data fetched successfully");
			structure.setData(presentation);
			
			return new ResponseEntity<ResponseStructure<Presentation>>(structure,HttpStatus.OK);
		}
		else {
			throw new PresentationIdNotFoundException("invalid id: " + pid);
		}

		
	}
	
	public ResponseEntity<ResponseStructure<Presentation>> calculatePresentationMarks(int pid){
		Presentation presentation=presentationDao.findPresentationById(pid);
		double totalMarks=0;
		double totalNoOfReviews=0;
		double finalMarks=0;
		if(presentation!=null && presentation.getStatus()==PresentationStatus.Completed) {
			
			List<Review> reviews=presentationDao.getAllReview(pid);
			totalNoOfReviews=reviews.size();
			if(reviews.size()>0) {
				
				for (Review review : reviews) {
					totalMarks=totalMarks+review.getCommunication()+review.getConfidence()
					+review.getContent()+review.getEnergy()+review.getEyecontact()+review.getInteraction()+
					review.getLiveliness();
				}
				
				finalMarks=totalMarks/totalNoOfReviews;
				presentation.setTotalMarks(finalMarks);
				presentationDao.upadtePresentation(presentation);
				
				ResponseStructure<Presentation> structure =new ResponseStructure<>();
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				structure.setMessage("marks calculated successfully");
				structure.setData(presentation);
				
				return new ResponseEntity<ResponseStructure<Presentation>>(structure,HttpStatus.ACCEPTED);
			
			}
			else {
				throw new ReviewsNotGivenException("reviews not given for the presentation");
			}
		}
		else {
			throw new PresentationIdNotFoundException("invalid id: " + pid);
		}
		
	}
	
}
