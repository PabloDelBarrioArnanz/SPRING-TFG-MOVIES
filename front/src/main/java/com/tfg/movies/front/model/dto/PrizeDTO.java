package com.tfg.movies.front.model.dto;

import com.tfg.movies.front.model.entity.Movie;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class PrizeDTO {

  private String name;
  private LocalDate concessionDate;
  private Set<Movie> movies = new HashSet<>();
}
