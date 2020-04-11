package com.tfg.movies.front.comunication.director;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class DirectorReceptor {

  @StreamListener(DirectorStream.SAVE_DIRECTOR_RESPONSE)
  public void savedActor(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Director save response :: "  + directorMessage.getDirectorDTO()));
  }

  @StreamListener(DirectorStream.DELETE_DIRECTOR_RESPONSE)
  public void deletedActor(@Payload Boolean status) {
    runAsync(() -> log.info("Director deleted response :: " + status));
  }

  @StreamListener(DirectorStream.READ_DIRECTOR_RESPONSE)
  public void receivedActor(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Director read request info :: " + directorMessage.getDirectorDTO()));
  }
}
