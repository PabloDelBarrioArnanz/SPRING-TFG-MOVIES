package com.tfg.movies.back.model.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
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

  public MovieDTO setTitle(String title) {
    this.title = title;
    return this;
  }

  public MovieDTO setData(byte[] data) {
    this.data = data;
    return this;
  }

  public MovieDTO setDuration(double duration) {
    this.duration = duration;
    return this;
  }

  public MovieDTO setCountry(String country) {
    this.country = country;
    return this;
  }

  public MovieDTO setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public MovieDTO setSynopsis(String synopsis) {
    this.synopsis = synopsis;
    return this;
  }

  public MovieDTO setPremiereDate(LocalDate premiereDate) {
    this.premiereDate = premiereDate;
    return this;
  }

  public MovieDTO setDirectors(Set<DirectorDTO> directors) {
    this.directors = directors;
    return this;
  }

  public MovieDTO setActors(Set<ActorDTO> actors) {
    this.actors = actors;
    return this;
  }

  public MovieDTO setScore(double score) {
    this.score = score;
    return this;
  }

  public MovieDTO setPrizes(Set<PrizeDTO> prizes) {
    this.prizes = prizes;
    return this;
  }

  public MovieDTO setReviews(Set<ReviewDTO> reviews) {
    this.reviews = reviews;
    return this;
  }
}
