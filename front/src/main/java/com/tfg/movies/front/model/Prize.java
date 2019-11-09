package com.tfg.movies.front.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Prize {

  private Integer id;
  private String name;
  private LocalDate concessionDate;
  private List<Movie> movies;

}
