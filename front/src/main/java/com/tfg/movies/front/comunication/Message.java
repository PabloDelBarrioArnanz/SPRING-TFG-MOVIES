package com.tfg.movies.front.comunication;

import com.tfg.movies.front.model.dto.MovieDTO;
import com.tfg.movies.front.model.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class Message {

  private Movie movie;
  private MovieDTO movieDTO;

  public Message withMovie(Movie movie) {
    this.movie = movie;
    return this;
  }

  public Message withMovieDTO(MovieDTO movieDTO) {
    this.movieDTO = movieDTO;
    return this;
  }

}
