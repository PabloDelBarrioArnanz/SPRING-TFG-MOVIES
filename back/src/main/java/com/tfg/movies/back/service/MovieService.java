package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.error.MessageErrorSender;
import com.tfg.movies.back.comunication.movie.MessageMovieSender;
import com.tfg.movies.back.comunication.movie.MovieMessage;
import com.tfg.movies.back.repository.MovieRepository;
import com.tfg.movies.back.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;
  @Autowired private MovieMapper movieMapper;
  @Autowired private MessageMovieSender messageMovieSender;
  @Autowired private MessageErrorSender messageErrorSender;

  public void saveMovie(MovieMessage movieMessage) {
    Optional.of(movieMessage)
      .map(movieMapper::toMovie)
      .map(movie -> movieRepository.save(movie))
      .map(movieMapper::toMessage)
      .ifPresent(messageToSend -> messageMovieSender.sendMessageMovieSaved(messageToSend));
  }

  public void readMoviesByTitle(String title) {
    movieRepository.findByTitle(title)
      .parallelStream()
      .map(movieMapper::toMessage)
      .forEach(message -> messageMovieSender.sendMessageMoviesRead(message));
  }

  public void readAllMovies() {
    movieRepository.findAll()
      .parallelStream()
      .map(movieMapper::toMessage)
      .forEach(message -> messageMovieSender.sendMessageMoviesRead(message));
  }

  public void deleteMovieByTitle(String title) {
    Optional.of(title)
      .map(movieRepository::findByTitle)
      .map(l -> l.get(0))
      .map(peek(movieRepository::delete))
      .map(id -> messageMovieSender.sendMessageMovieDeleted(Boolean.TRUE))
      .orElseGet(() -> messageErrorSender.sendMessageError("Imposible to delete this movie"));
  }

  private <T> UnaryOperator<T> peek(Consumer<T> c) {
    return x -> {
      c.accept(x);
      return x;
    };
  }
}
