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
public class DirectorReceptor {

  @Autowired private DirectorService directorService;

  @StreamListener(DirectorStream.SAVE_DIRECTOR_REQUEST)
  public void directorToSave(@Payload DirectorMessage directorMessage) {
    runAsync(() -> log.info("Received a director for save :: " + directorMessage.getDirectorDTO()))
      .thenRunAsync(() -> directorService.saveDirector(directorMessage));
  }

  @StreamListener(DirectorStream.READ_DIRECTOR_REQUEST)
  public void directorToRead(@Payload String name) {
    runAsync(() -> log.info("Received a name to read a director :: " + name))
      .thenRunAsync(() -> directorService.readDirectorByName(name));
  }

  @StreamListener(DirectorStream.READ_ALL_DIRECTORS_REQUEST)
  public void directorsToRead() {
    runAsync(() -> log.info("Received a request to read :: all directors"))
      .thenRunAsync(() -> directorService.readAllDirectors());
  }

  @StreamListener(DirectorStream.DELETE_DIRECTOR_REQUEST)
  public void directorToDelete(@Payload String name) {
    runAsync(() -> log.info("Received a name to delete a director :: " + name))
      .thenRunAsync(() -> directorService.deleteDirectorByName(name));
  }

}
