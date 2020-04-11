package com.tfg.movies.front.model.dto;

import com.tfg.movies.front.model.entity.Movie;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Data
@ToString
public class DirectorDTO {

  private String name;
  private Integer age;
  private Set<Movie> movies = new HashSet<>();
}
