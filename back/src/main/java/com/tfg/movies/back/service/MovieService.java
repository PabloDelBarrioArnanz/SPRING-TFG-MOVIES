package com.tfg.movies.back.service;

import com.tfg.movies.back.comunication.error.ErrorMessage;
import com.tfg.movies.back.comunication.error.ErrorSender;
import com.tfg.movies.back.comunication.movie.MovieMessage;
import com.tfg.movies.back.comunication.movie.MovieSender;
import com.tfg.movies.back.model.entity.Movie;
import com.tfg.movies.back.repository.MovieRepository;
import com.tfg.movies.back.service.mapper.MovieMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import static com.tfg.movies.back.service.Util.peek;

@Service
@AllArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;
  private final MovieMapper movieMapper;
  private final MovieSender movieSender;
  private final ErrorSender errorSender;

  private static final String SAVE_ERROR = "Impossible to save this movie";
  private static final String MOVIE_NOT_FOUND = "Movie doesn't exist";
  private static final String MOVIE_NOT_DELETED = "Impossible to delete this movie";
  private static final String MOVIE_NOT_VOTED = "Impossible to vote this movie";

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
        Comparator.comparingDouble(Movie::getScore)
          .thenComparing(Movie::getTitle) :
        Comparator.comparing(Movie::getTitle))
      .map(movieMapper::toMessage)
      .forEach(movieSender::sendMessageMovieRead);
  }

  public void deleteMovieByTitle(String title) {
    Optional.ofNullable(title)
      .map(peek(movieRepository::deleteById))
      .map(id -> movieSender.sendMessageMovieDeleted(Boolean.TRUE))
      .orElseGet(() -> errorSender.sendMessageError(new ErrorMessage(MOVIE_NOT_DELETED)));
  }

  public void voteMovieByTitle(MovieMessage movieMessage) {
    Function<Movie, String> updateScoreMovie = movie -> Optional.of(movie)
      .map(mov -> mov.getScore() + ((mov.getVote() - mov.getScore()) / (mov.getTotalVotes() + 1)))
      .map(movie::setScore)
      .map(mov -> mov.setTotalVotes(mov.getTotalVotes() + 1))
      .map(movieRepository::save)
      .map(mov -> "New score " + mov.getScore() + " for movie " + mov.getTitle())
      .orElse(MOVIE_NOT_VOTED);

    applyOperation(movieMessage, movieMapper::toMovie, movie -> movieRepository.findByTitle(movie.getTitle()), updateScoreMovie, movieSender::sendMessageMovieVoted, MOVIE_NOT_VOTED);
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
