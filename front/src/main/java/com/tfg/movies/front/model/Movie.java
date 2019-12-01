package com.tfg.movies.front.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotEmpty
  private String title;

  private byte[] data;

  @Min(1)
  @Max(500)
  private double duration;

  @NotEmpty
  private String country;

  @NotEmpty
  private String gender;

  @NotEmpty
  private String synopsis;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate premiereDate;

  @NotEmpty
  @ElementCollection
  private List<Director> director;

  @NotEmpty
  @ElementCollection
  private List<Actor> actors;

  @Min(0)
  @Max(100)
  private double score;

  @ElementCollection
  private List<Prize> prizes;

  @ElementCollection
  private List<Review> reviews;

  public Movie setTitle(String title) {
    this.title = title;
    return this;
  }

}
