package com.tfg.movies.back.model.dto;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@ToString
public class PrizeDTO {

  private String name;
  private LocalDate concessionDate;
  private Set<String> movies = new HashSet<>();

  public PrizeDTO setName(String name) {
    this.name = name;
    return this;
  }

  public PrizeDTO setConcessionDate(LocalDate concessionDate) {
    this.concessionDate = concessionDate;
    return this;
  }

  public PrizeDTO setMovies(Set<String> movies) {
    this.movies = movies;
    return this;
  }
}
