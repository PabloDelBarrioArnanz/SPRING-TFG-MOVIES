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
public class MessageActorReceptor {

  @Autowired private ActorService actorService;

  @StreamListener(MessageActorStream.ACTOR_TO_SAVE)
  public void actorToSave(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Received a message to save a actor " + actorMessage))
      .thenRunAsync(() -> actorService.saveActor(actorMessage));
  }

  @StreamListener(MessageActorStream.ACTOR_TO_READ)
  public void actorToRead(@Payload String name) {
    runAsync(() -> log.info("Received a message: actor to read " + name))
      .thenRunAsync(() -> actorService.readActorsByName(name));
  }

  @StreamListener(MessageActorStream.ACTORS_TO_READ)
  public void actorsToRead() {
    runAsync(() -> log.info("Received a message: read all actors"))
      .thenRunAsync(() -> actorService.readAllActors());
  }

  @StreamListener(MessageActorStream.ACTOR_TO_DELETE)
  public void actorToDelete(@Payload String name) {
    runAsync(() -> log.info("Received a message: actor to delete " + name))
      .thenRunAsync(() -> actorService.deleteActorByName(name));
  }

}
