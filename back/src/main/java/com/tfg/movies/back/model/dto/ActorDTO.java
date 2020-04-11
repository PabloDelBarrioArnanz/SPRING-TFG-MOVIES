package com.tfg.movies.back.model.dto;

import com.tfg.movies.back.model.entity.Movie;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
public class ActorDTO {

  private String name;
  private String rol;
  private Integer age;
  private Set<Movie> movies = new HashSet<>();

  public ActorDTO setName(String name) {
    this.name = name;
    return this;
  }

  public ActorDTO setRol(String rol) {
    this.rol = rol;
    return this;
  }

  public ActorDTO setAge(Integer age) {
    this.age = age;
    return this;
  }

  public ActorDTO setMovies(Set<Movie> movies) {
    this.movies = movies;
    return this;
  }
}
