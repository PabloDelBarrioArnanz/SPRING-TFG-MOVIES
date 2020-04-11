package com.tfg.movies.back.comunication.movie;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tfg.movies.back.model.dto.MovieDTO;
import com.tfg.movies.back.model.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieMessage {

  private Movie movie;
  private MovieDTO movieDTO;

  public MovieMessage withMovieDTO(MovieDTO movieDTO) {
    this.movieDTO = movieDTO;
    return this;
  }
}
