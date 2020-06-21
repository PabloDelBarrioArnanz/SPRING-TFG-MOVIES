package com.tfg.movies.front.model.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ActorDTO {

  private String name;
  private String rol;
  private Integer age;
  private Set<String> movies = new HashSet<>();

  @Override
  public String toString() {
    return "Nombre: " + name +
      Optional.of(movies)
        .filter(Set::isEmpty)
        .map(movies -> "\n\t\t\tEdad: " + age +"\n\t\t\tRol: " + rol)
        .orElseGet(() -> "\n\tEdad: " + age +"\n\t" + movies.stream().collect(Collectors.joining(",\n\t\t", "Peliculas interpretadas: \n\t\t", ".\n")) + "\n");
  }
}
