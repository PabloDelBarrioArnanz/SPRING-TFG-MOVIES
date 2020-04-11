package com.tfg.movies.front.comunication.director;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageDirectorReceptor {

  @StreamListener(MessageDirectorStream.DIRECTOR_SAVED)
  public void savedActor(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Received saved info " + directorMessage));
  }

  @StreamListener(MessageDirectorStream.DIRECTOR_DELETED)
  public void deletedActor(@Payload Boolean status) {
    runAsync(() -> log.info("Received deleted info " + status));
  }

  @StreamListener(MessageDirectorStream.DIRECTOR_READY_READ)
  public void receivedActor(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Received director " + directorMessage));
  }
}
