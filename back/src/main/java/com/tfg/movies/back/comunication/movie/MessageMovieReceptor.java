package com.tfg.movies.back.comunication.movie;

import com.tfg.movies.back.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageMovieReceptor {

  @Autowired private MovieService movieService;

  @StreamListener(MessageMovieStream.MOVIE_TO_SAVE)
  public void movieToSave(@Payload MovieMessage movieMessage) {
    runAsync(() -> log.info("Received a message to save a movie " + movieMessage))
      .thenRunAsync(() -> movieService.saveMovie(movieMessage));
  }

  @StreamListener(MessageMovieStream.MOVIE_TO_READ)
  public void movieToRead(@Payload String title) {
    runAsync(() -> log.info("Received a message: movie to read " + title))
      .thenRunAsync(() -> movieService.readMoviesByTitle(title));
  }

  @StreamListener(MessageMovieStream.MOVIES_TO_READ)
  public void moviesToRead() {
    runAsync(() -> log.info("Received a message: read all movies"))
      .thenRunAsync(() -> movieService.readAllMovies());
  }

  @StreamListener(MessageMovieStream.MOVIE_TO_DELETE)
  public void movieToDelete(@Payload String title) {
    runAsync(() -> log.info("Received a message: movie to delete " + title))
      .thenRunAsync(() -> movieService.deleteMovieByTitle(title));
  }

}
