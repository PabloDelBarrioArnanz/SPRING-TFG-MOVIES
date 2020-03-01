package com.tfg.movies.back.model.dto;

import com.tfg.movies.back.model.entity.Movie;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class DirectorDTO {

  private String name;
  private Integer age;
  private Set<Movie> movies = new HashSet<>();

  public DirectorDTO setName(String name) {
    this.name = name;
    return this;
  }

  public DirectorDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  public DirectorDTO setMovies(Set<Movie> movies) {
    this.movies = movies;
    return this;
  }
}
