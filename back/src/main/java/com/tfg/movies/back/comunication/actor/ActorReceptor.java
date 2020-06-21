package com.tfg.movies.back.comunication.actor;

import com.tfg.movies.back.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class ActorReceptor {

  @Autowired private ActorService actorService;

  @StreamListener(ActorStream.SAVE_ACTOR_REQUEST)
  public void actorToSave(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Received an actor for save :: " + actorMessage.getActorDTO()))
      .thenRunAsync(() -> actorService.saveActor(actorMessage));
  }

  @StreamListener(ActorStream.READ_ACTOR_REQUEST)
  public void actorToRead(@Payload String name) {
    runAsync(() -> log.info("Received a name to read an actor :: " + name))
      .thenRunAsync(() -> actorService.readActorByName(name));
  }

  @StreamListener(ActorStream.READ_ALL_ACTORS_REQUEST)
  public void actorsToRead() {
    runAsync(() -> log.info("Received a request to read :: all actors"))
      .thenRunAsync(() -> actorService.readAllActors());
  }

  @StreamListener(ActorStream.DELETE_ACTOR_REQUEST)
  public void actorToDelete(@Payload String name) {
    runAsync(() -> log.info("Received a name to delete an actor :: " + name))
      .thenRunAsync(() -> actorService.deleteActorByName(name));
  }

}
