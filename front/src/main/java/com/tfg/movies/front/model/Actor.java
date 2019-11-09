package com.tfg.movies.front.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Actor {

  private Integer id;
  private String name;
  private String rol;
  private Integer age;
  private List<Movie> movies;

}
