package com.tfg.movies.back.model.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class DirectorDTO {

  private String name;
  private Integer age;
  private Set<String> movies = new HashSet<>();

  public DirectorDTO setName(String name) {
    this.name = name;
    return this;
  }

  public DirectorDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  public DirectorDTO setMovies(Set<String> movies) {
    this.movies = movies;
    return this;
  }
}
