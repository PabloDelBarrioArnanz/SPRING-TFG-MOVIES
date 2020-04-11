package com.tfg.movies.back.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Director {

  @Id
  @Column(nullable = false)
  private String name;

  private Integer age;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "directors")
  private Set<Movie> movies = new HashSet<>();;

}
