package com.tfg.movies.front.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Review {

  private Integer id;
  private String reviewer;
  private LocalDate reviewDate;

}
