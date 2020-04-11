package com.tfg.movies.back.comunication.director;

import com.tfg.movies.back.service.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageDirectorReceptor {

  @Autowired private DirectorService directorService;

  @StreamListener(MessageDirectorStream.DIRECTOR_TO_SAVE)
  public void directorToSave(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Received a message to save a director " + directorMessage))
      .thenRunAsync(() -> directorService.saveDirector(directorMessage));
  }

  @StreamListener(MessageDirectorStream.DIRECTOR_TO_READ)
  public void directorToRead(@Payload String name) {
    runAsync(() -> log.info("Received a message: director to read " + name))
      .thenRunAsync(() -> directorService.readDirectorsByName(name));
  }

  @StreamListener(MessageDirectorStream.DIRECTORS_TO_READ)
  public void directorsToRead() {
    runAsync(() -> log.info("Received a message: read all directors"))
      .thenRunAsync(() -> directorService.readAllDirectors());
  }

  @StreamListener(MessageDirectorStream.DIRECTOR_TO_DELETE)
  public void directorToDelete(@Payload String name) {
    runAsync(() -> log.info("Received a message: director to delete " + name))
      .thenRunAsync(() -> directorService.deleteDirectorByName(name));
  }

}
