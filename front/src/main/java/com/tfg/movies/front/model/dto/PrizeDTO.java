package com.tfg.movies.front.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class PrizeDTO {

  private String name;
  private LocalDate concessionDate;
  private Set<String> movies = new HashSet<>();

  @Override
  public String toString() {
    return "Premio: " + name
      + "\n\t\t\tCondecido en: " + concessionDate;
  }
}
