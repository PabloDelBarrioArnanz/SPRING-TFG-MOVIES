package com.tfg.movies.front.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Director {

  private Integer id;
  private String name;
  private Integer age;
  private List<Movie> movies;

}
