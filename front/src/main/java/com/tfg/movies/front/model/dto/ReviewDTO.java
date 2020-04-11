package com.tfg.movies.front.model.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class ReviewDTO {

  private String reviewer;
  private String review;
  private LocalDate reviewDate;
}
