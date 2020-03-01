package com.tfg.movies.front.model.dto;

import com.tfg.movies.front.model.entity.Movie;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class ActorDTO {

  private String name;
  private String rol;
  private Integer age;
  private Set<Movie> movies = new HashSet<>();
}
