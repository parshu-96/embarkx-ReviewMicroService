package com.embarkx.reviewms.review;
import java.util.List;
public interface ReviewService {
    List<Review> getAllReviews(Long companyID);
    boolean addReview(Long companyId,Review review);
    Review getReviewById(Long reviewId);
    boolean updateReview(Long reviewId,Review review);
    boolean deleteReviewById(Long reviewId);
}
