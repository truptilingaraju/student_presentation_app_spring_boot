package com.ty.presentation_review_app_spring_boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentation_review_app_spring_boot.dao.PresentationDao;
import com.ty.presentation_review_app_spring_boot.dao.ResponseStructure;
import com.ty.presentation_review_app_spring_boot.dao.ReviewDao;
import com.ty.presentation_review_app_spring_boot.dao.UserDao;
import com.ty.presentation_review_app_spring_boot.dto.Presentation;
import com.ty.presentation_review_app_spring_boot.dto.PresentationStatus;
import com.ty.presentation_review_app_spring_boot.dto.Review;
import com.ty.presentation_review_app_spring_boot.dto.User;
import com.ty.presentation_review_app_spring_boot.exception.PresentationIdNotFoundException;
import com.ty.presentation_review_app_spring_boot.exception.PresentationIsInAssignedStateException;
import com.ty.presentation_review_app_spring_boot.exception.UnauthorizedSelfReviewException;
import com.ty.presentation_review_app_spring_boot.exception.VotingClosedException;

import ch.qos.logback.core.status.Status;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDao reviewDaoObject;
	
	@Autowired
	UserDao userDaoObject;
	
	
	@Autowired
	PresentationDao presentationDaoObject;
	
	public ResponseEntity<ResponseStructure<Review>> saveReview(Review paasedReview,int presentationId,int userId)
	{
		
		Presentation presentation=presentationDaoObject.findPresentationById(presentationId);
		
		if(presentation!=null)
		{
            User user=presentation.getPresentor();
            
            if(user.getId()!=userId)
            {
            	
            	if(presentation.getStatus()==PresentationStatus.Assigned)
            	{
            		throw new PresentationIsInAssignedStateException();
            	}
            	if(presentation.getStatus()==PresentationStatus.VotingPollOn)
            	{
            		paasedReview.setVoter(user);
                	
                	List<Review> reviewList=presentation.getReviews();
                	
                	if(reviewList==null)
                	{
                		reviewList= new ArrayList();
                	}
                	
                	
                		reviewList.add(paasedReview);
                		presentation.setReviews(reviewList);
                		presentation.setReviews(reviewList);
                		reviewDaoObject.SaveReview(paasedReview);
                		presentationDaoObject.savePresentation(presentation);
                		
                		
                		ResponseStructure<Review> responseStructure= new ResponseStructure<Review>();
            			responseStructure.setMessage("Success");
            			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
            			responseStructure.setData(paasedReview);
                        return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);			
            		
            	}
            	else
            	{
            		throw new VotingClosedException();
            	}
            	
            	
            	
        			
        	}
            else
            {
            	throw new UnauthorizedSelfReviewException();

            }
			
		}
		else
		{
			throw new PresentationIdNotFoundException();
		}
		
		
		
		
				
	}
	
	

}
