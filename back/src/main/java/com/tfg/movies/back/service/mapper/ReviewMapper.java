package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.model.dto.ReviewDTO;
import com.tfg.movies.back.model.entity.Review;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {
  public Set<ReviewDTO> toReviewDTO(Set<Review> reviews) {
    return reviews.stream()
      .map(this::toReviewDTO)
      .collect(Collectors.toSet());
  }

  public ReviewDTO toReviewDTO(Review review) {
    return new ReviewDTO()
      .setReview(review.getReview())
      .setReviewDate(review.getReviewDate())
      .setReviewer(review.getReviewer());
  }
}
