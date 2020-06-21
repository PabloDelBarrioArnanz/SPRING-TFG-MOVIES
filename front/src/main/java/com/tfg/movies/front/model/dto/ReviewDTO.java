package com.tfg.movies.front.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {

  private String reviewer;
  private String review;
  private LocalDate reviewDate;

  @Override
  public String toString() {
    return "Ciritico: " + reviewer
      + "\n\t\t\tCritica: " + review
      + "\n\t\t\tFecha: " + reviewDate;
  }
}
