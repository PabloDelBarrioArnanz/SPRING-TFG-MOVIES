package com.tfg.movies.front.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Director {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NotEmpty
  private String name;

  @NotEmpty
  private Integer age;

  @ElementCollection
  private List<Movie> movies;

  public Director setName(String name) {
    this.name = name;
    return this;
  }
}
