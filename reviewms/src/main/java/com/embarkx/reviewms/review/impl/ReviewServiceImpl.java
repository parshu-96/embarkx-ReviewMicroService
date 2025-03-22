package com.embarkx.reviewms.review.impl;


import com.embarkx.reviewms.review.Review;
import com.embarkx.reviewms.review.ReviewRepository;
import com.embarkx.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepo;

    public ReviewServiceImpl(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> getAllReviews(Long companyID) {
        List<Review> reviews=reviewRepo.findByCompanyId(companyID);
        return reviews;
    }
 
    @Override
    public boolean addReview(Long companyId, Review review) {

        if(companyId!=null && review !=null) {
            review.setCompanyId(companyId);
            reviewRepo.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Review review = reviewRepo.findById(reviewId).orElse(null);
        if (review != null) {
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyId(updatedReview.getCompanyId());
            reviewRepo.save(review);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        Review review=reviewRepo.findById(reviewId).orElse(null);
        if(review!=null)
        {
            reviewRepo.delete(review);
            return true;
        }
        return false;
    }
}
