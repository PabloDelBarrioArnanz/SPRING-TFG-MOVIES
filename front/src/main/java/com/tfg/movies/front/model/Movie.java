package com.tfg.movies.front.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {

  private Integer id;
  @NotNull
  private String title;
  private byte[] data;
  @NotNull
  private double duration;
  @NotNull
  private String country;
  @NotNull
  private String gender;
  @NotNull
  private String synopsis;
  @NotNull
  private LocalDate premiereDate;
  @NotNull
  private Director director;
  @NotNull
  private List<Actor> actors;
  @NotNull
  @Min(0)
  @Max(10)
  private double valoration;
  @NotNull
  private List<Prize> prizes;
  @NotNull
  private List<Review> reviews;

  public Movie setTitle(String title) {
    this.title = title;
    return this;
  }

}
