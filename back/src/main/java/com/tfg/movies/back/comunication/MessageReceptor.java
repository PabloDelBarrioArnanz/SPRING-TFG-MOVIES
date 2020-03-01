package com.tfg.movies.back.comunication;

import com.tfg.movies.back.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageReceptor {

  @Autowired
  private MovieService movieService;

  @StreamListener(MessageStream.MOVIE_TO_SAVE)
  public void movieToSave(@Payload Message message) {
    runAsync(() -> log.info("Received a message: movie to save " + message))
      .thenRunAsync(() -> movieService.saveMovie(message));
  }

  @StreamListener(MessageStream.MOVIE_TO_READ)
  public void movieToRead(@Payload String title) {
    runAsync(() -> log.info("Received a message: movie to read " + title))
      .thenRunAsync(() -> movieService.readMoviesByTitle(title));
  }

  @StreamListener(MessageStream.MOVIES_TO_READ)
  public void moviesToRead() {
    runAsync(() -> log.info("Received a message: read all movies"))
      .thenRunAsync(() -> movieService.readAllMovies());
  }

  @StreamListener(MessageStream.MOVIE_TO_DELETE)
  public void movieToDelete(@Payload String title) {
    runAsync(() -> log.info("Received a message: movie to delete " + title))
      .thenRunAsync(() -> movieService.deleteMovieByTitle(title));
  }

}
