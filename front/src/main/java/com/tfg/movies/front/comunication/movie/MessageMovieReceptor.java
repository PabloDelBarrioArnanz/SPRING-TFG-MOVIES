package com.tfg.movies.front.comunication.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageMovieReceptor {

  @StreamListener(MessageMovieStream.MOVIE_SAVED)
  public void savedMovie(@Payload MovieMessage movieMessage) {
    runAsync(() -> log.info("Received saved info " + movieMessage));
  }

  @StreamListener(MessageMovieStream.MOVIE_DELETED)
  public void deletedMovie(@Payload Boolean status) {
    runAsync(() -> log.info("Received deleted info " + status));
  }
}
