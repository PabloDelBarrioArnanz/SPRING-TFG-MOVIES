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
public class MovieReceptor {

  @Autowired private MovieService movieService;

  @StreamListener(MovieStream.SAVE_MOVIE_REQUEST)
  public void movieToSave(@Payload MovieMessage movieMessage) {
    runAsync(() -> log.info("Received a movie for save :: " + movieMessage.getMovie()))
      .thenRunAsync(() -> movieService.saveMovie(movieMessage));
  }

  @StreamListener(MovieStream.READ_MOVIE_REQUEST)
  public void movieToRead(@Payload String title) {
    runAsync(() -> log.info("Received a title to read a movie :: " + title))
      .thenRunAsync(() -> movieService.readMovieByTitle(title));
  }

  @StreamListener(MovieStream.READ_ALL_MOVIES_REQUEST)
  public void moviesToRead(@Payload Boolean order) {
    runAsync(() -> log.info("Received a request to read :: all movies"))
      .thenRunAsync(() -> movieService.readAllMovies(order));
  }

  @StreamListener(MovieStream.DELETE_MOVIE_REQUEST)
  public void movieToDelete(@Payload String title) {
    runAsync(() -> log.info("Received a title to delete a movie :: " + title))
      .thenRunAsync(() -> movieService.deleteMovieByTitle(title));
  }
}
