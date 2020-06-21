package com.tfg.movies.front.service.mapper;

import com.tfg.movies.front.comunication.movie.MovieMessage;
import com.tfg.movies.front.model.dto.MovieDTO;
import com.tfg.movies.front.model.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  public MovieMessage toMovieMessage(Movie movie) {
    return new MovieMessage().withMovie(movie);
  }

  public MovieMessage toMovieMessage(String title) {
    return new MovieMessage().withMovie(new Movie().setTitle(title));
  }

  public Movie toMovie(MovieMessage movieMessage) {
    return movieMessage.getMovie();
  }

  public MovieDTO toMovieDTO(MovieMessage movieMessage) {
    return movieMessage.getMovieDTO();
  }

}
