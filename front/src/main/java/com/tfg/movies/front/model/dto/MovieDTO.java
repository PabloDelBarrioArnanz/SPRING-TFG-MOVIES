package com.tfg.movies.front.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {

  private String title;
  private byte[] data;
  private double duration;
  private String country;
  private String gender;
  private String synopsis;
  private LocalDate premiereDate;
  private Set<DirectorDTO> directors = new HashSet<>();
  private Set<ActorDTO> actors = new HashSet<>();
  private double score;
  private Set<PrizeDTO> prizes = new HashSet<>();
  private Set<ReviewDTO> reviews = new HashSet<>();

  @Override
  public String toString() {
    return
      "\n~Titulo: " + title + "\n"
        + "\t-Content: " + Arrays.toString(data) + "\n"
        + "\t-Duracion: " + duration + "\n"
        + "\t-Pais: " + country + "\n"
        + "\t-Genero: " + gender + "\n"
        + "\t-Synopsis: " + synopsis + "\n"
        + "\t-Valoracion: " + score + "\n"
        + "\t-Fecha de estreno: " + premiereDate + "\n"
        + "\t-Dirigida por: " + "\n"
        + "\t\t" + directors.stream().map(DirectorDTO::toString).collect(Collectors.joining("\n\t\t")) + "\n"
        + "\t-Reparto: " + "\n"
        + "\t\t" + actors.stream().map(ActorDTO::toString).collect(Collectors.joining("\n\t\t")) + "\n"
        + "\t-Premios: " + "\n"
        + "\t\t" + prizes.stream().map(PrizeDTO::toString).collect(Collectors.joining("\n\t\t")) + "\n"
        + "\t-Opiniones: " + "\n"
        + "\t\t" + reviews.stream().map(ReviewDTO::toString).collect(Collectors.joining("\n"));
  }
}
