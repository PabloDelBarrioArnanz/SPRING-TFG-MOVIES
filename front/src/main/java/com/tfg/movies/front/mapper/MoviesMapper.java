package com.tfg.movies.front.mapper;

import com.tfg.movies.front.comunication.Message;
import com.tfg.movies.front.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {

  public Message toMessage(Movie movie) {
    return new Message().setMovie(movie);
  }

  public Message toMessage(String title) {
    return new Message().setMovie(new Movie().setTitle(title));
  }

  public Movie toMovie(Message message) {
    return message.getMovie();
  }

}
