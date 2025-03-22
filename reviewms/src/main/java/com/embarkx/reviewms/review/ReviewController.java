package com.embarkx.reviewms.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        System.out.println("In Reviews");
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        if (reviewService.addReview(companyId, review))
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Cannot add review", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        if (reviewService.updateReview(reviewId, review))
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not Updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        if (reviewService.deleteReviewById(reviewId))
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not Deleted", HttpStatus.NOT_FOUND);
    }


}
