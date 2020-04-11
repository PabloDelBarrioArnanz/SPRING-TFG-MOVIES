package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.error.ErrorMessage;
import com.tfg.movies.back.comunication.error.ErrorSender;
import com.tfg.movies.back.comunication.movie.MovieMessage;
import com.tfg.movies.back.comunication.movie.MovieSender;
import com.tfg.movies.back.repository.MovieRepository;
import com.tfg.movies.back.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tfg.movies.back.service.Util.peek;

@Service
public class MovieService {

  @Autowired private MovieRepository movieRepository;
  @Autowired private MovieMapper movieMapper;
  @Autowired private MovieSender movieSender;
  @Autowired private ErrorSender errorSender;

  public void saveMovie(MovieMessage movieMessage) {
    Optional.ofNullable(movieMessage)
      .map(movieMapper::toMovie)
      .map(movie -> movieRepository.save(movie))
      .map(movieMapper::toMessage)
      .map(messageToSend -> movieSender.sendMessageMovieSaved(messageToSend))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to save this movie")));
  }

  public void readMovieByTitle(String title) {
    Optional.ofNullable(title)
      .flatMap(movieRepository::findByTitle)
      .map(movieMapper::toMessage)
      .map(message -> movieSender.sendMessageMovieRead(message))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Movie doesn't exist")));
  }

  public void readAllMovies() {
    movieRepository.findAll()
      .parallelStream()
      .map(movieMapper::toMessage)
      .forEach(message -> movieSender.sendMessageMovieRead(message));
  }

  public void deleteMovieByTitle(String title) {
    Optional.ofNullable(title)
      .map(peek(movieRepository::deleteById))
      .map(id -> movieSender.sendMessageMovieDeleted(Boolean.TRUE))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage().withError("Impossible to delete this movie")));
  }
}
