package com.tfg.movies.back.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private Integer age;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "directors")
  private Set<Movie> movies = new HashSet<>();;

}
