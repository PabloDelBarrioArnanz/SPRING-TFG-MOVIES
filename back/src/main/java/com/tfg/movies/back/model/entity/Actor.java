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
public class Actor {

  @Id
  @Column(nullable = false)
  private String name;

  private String rol;

  private Integer age;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "actors")
  private Set<Movie> movies = new HashSet<>();

}
