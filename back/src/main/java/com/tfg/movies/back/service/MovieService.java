package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.error.ErrorMessage;
import com.tfg.movies.back.comunication.error.ErrorSender;
import com.tfg.movies.back.comunication.movie.MovieMessage;
import com.tfg.movies.back.comunication.movie.MovieSender;
import com.tfg.movies.back.model.entity.Movie;
import com.tfg.movies.back.repository.MovieRepository;
import com.tfg.movies.back.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import static com.tfg.movies.back.service.Util.peek;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private MovieMapper movieMapper;
  @Autowired
  private MovieSender movieSender;
  @Autowired
  private ErrorSender errorSender;

  private static final String SAVE_ERROR = "Impossible to save this movie";
  private static final String MOVIE_NOT_FOUND = "Movie doesn't exist";
  private static final String MOVIE_NOT_DELETED = "Impossible to delete this movie";

  public void saveMovie(MovieMessage movieMessage) {
    applyOperation(movieMessage, movieMapper::toMovie, (movie) -> Optional.of(movieRepository.save(movie)), movieMapper::toMessage, movieSender::sendMessageMovieSaved, SAVE_ERROR);
  }

  public void readMovieByTitle(String title) {
    applyOperation(title, Function.identity(), movieRepository::findByTitle, movieMapper::toMessage, movieSender::sendMessageMovieRead, MOVIE_NOT_FOUND);
  }

  public void readAllMovies(Boolean sort) {
    movieRepository.findAll()
      .stream()
      .sorted(sort.equals(Boolean.TRUE) ?
        Comparator.comparing(Movie::getScore) : Comparator.comparing(Movie::getTitle))
      .map(movieMapper::toMessage)
      .forEach(message -> movieSender.sendMessageMovieRead(message));
  }

  public void deleteMovieByTitle(String title) {
    Optional.ofNullable(title)
      .map(peek(movieRepository::deleteById))
      .map(id -> movieSender.sendMessageMovieDeleted(Boolean.TRUE))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage(MOVIE_NOT_DELETED)));
  }

  private <T, E, W, S> void applyOperation(T payload, Function<T, E> reader, Function<E, Optional<W>> repositoryOperation, Function<W, S> mapper, Function<S, Boolean> sender, String reason) {
    Optional.of(payload)
      .map(reader)
      .flatMap(repositoryOperation)
      .map(mapper)
      .map(sender)
      .orElseGet(() -> errorHandler(reason));
  }

  private Boolean errorHandler(String reason) {
    return Optional.of(reason)
      .map(ErrorMessage::new)
      .map(errorSender::sendMessageError)
      .orElse(Boolean.FALSE);
  }
}
