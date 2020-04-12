package com.tfg.movies.front.comunication.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MovieReceptor {

  @StreamListener(MovieStream.SAVE_MOVIE_RESPONSE)
  public void savedMovie(@Payload MovieMessage movieMessage) {
    runAsync(() -> log.info("Movie save response :: \n" + movieMessage.getMovieDTO()));
  }

  @StreamListener(MovieStream.DELETE_MOVIE_RESPONSE)
  public void deletedMovie(@Payload Boolean status) {
    runAsync(() -> log.info("Movie deleted response :: \n" + status));
  }

  @StreamListener(MovieStream.READ_MOVIE_RESPONSE)
  public void receivedActor(@Payload MovieMessage movieMessage) {
    runAsync(() -> log.info("Movie read response info :: \n" + movieMessage.getMovieDTO()));
  }
}
