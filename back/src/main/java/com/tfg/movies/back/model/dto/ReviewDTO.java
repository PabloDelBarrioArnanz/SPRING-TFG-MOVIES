package com.tfg.movies.back.model.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReviewDTO {

  private String reviewer;
  private String review;
  private LocalDate reviewDate;

  public ReviewDTO setReviewer(String reviewer) {
    this.reviewer = reviewer;
    return this;
  }

  public ReviewDTO setReview(String review) {
    this.review = review;
    return this;
  }

  public ReviewDTO setReviewDate(LocalDate reviewDate) {
    this.reviewDate = reviewDate;
    return this;
  }
}
