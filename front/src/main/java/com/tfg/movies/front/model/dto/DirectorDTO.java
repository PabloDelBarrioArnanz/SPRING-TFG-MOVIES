package com.tfg.movies.front.model.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Data
public class DirectorDTO {

  private String name;
  private Integer age;
  private Set<String> movies = new HashSet<>();

  @Override
  public String toString() {
    return "Nombre: " + name +
      Optional.of(movies)
        .filter(Set::isEmpty)
        .map(movies -> "\n\t\t\tEdad: " + age)
        .orElseGet(() -> "\n\tEdad: " + age +"\n\t" + movies.stream().collect(Collectors.joining(",\n\t\t", "Peliculas dirigidas: \n\t\t", ".\n")) + "\n");
  }
}
