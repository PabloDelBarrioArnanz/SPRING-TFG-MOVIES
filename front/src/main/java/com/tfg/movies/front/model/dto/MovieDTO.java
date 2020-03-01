package com.tfg.movies.front.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class MovieDTO {

  private String title;
  private byte[] data;
  private double duration;
  private String country;
  private String gender;
  private String synopsis;
  private LocalDate premiereDate;
  private Set<DirectorDTO> directors = new HashSet<>();
  private Set<ActorDTO> actors = new HashSet<>();
  private double score;
  private Set<PrizeDTO> prizes = new HashSet<>();
  private Set<ReviewDTO> reviews = new HashSet<>();
}
