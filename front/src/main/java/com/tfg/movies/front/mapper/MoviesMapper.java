package com.tfg.movies.front.mapper;

import com.tfg.movies.front.comunication.Message;
import com.tfg.movies.front.model.dto.MovieDTO;
import com.tfg.movies.front.model.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {

  public Message toMessage(Movie movie) {
    return new Message().withMovie(movie);
  }

  public Message toMessage(String title) {
    return new Message().withMovie(new Movie().setTitle(title));
  }

  public Movie toMovie(Message message) {
    return message.getMovie();
  }

  public MovieDTO toMovieDTO(Message message) {
    return message.getMovieDTO();
  }

}
