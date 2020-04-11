package com.tfg.movies.back.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {

  @Id
  @Column(nullable = false)
  private String title;

  private byte[] data;

  private double duration;

  private String country;

  private String gender;

  private String synopsis;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate premiereDate;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "Movie_Director",
    joinColumns = { @JoinColumn(name = "movie_id") },
    inverseJoinColumns = { @JoinColumn(name = "director_id") }
  )
  private Set<Director> directors = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "Movie_Actor",
    joinColumns = { @JoinColumn(name = "movie_id") },
    inverseJoinColumns = { @JoinColumn(name = "actor_id") }
  )
  private Set<Actor> actors = new HashSet<>();

  private double score;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "Movie_Prize",
    joinColumns = { @JoinColumn(name = "movie_id") },
    inverseJoinColumns = { @JoinColumn(name = "prize_id") }
  )
  private Set<Prize> prizes = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "Movie_Review",
    joinColumns = { @JoinColumn(name = "movie_id") },
    inverseJoinColumns = { @JoinColumn(name = "review_id") }
  )
  private Set<Review> reviews = new HashSet<>();

}
