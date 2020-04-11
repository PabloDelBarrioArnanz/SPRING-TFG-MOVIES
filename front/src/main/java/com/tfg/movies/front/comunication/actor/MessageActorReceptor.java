package com.tfg.movies.front.comunication.actor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageActorReceptor {

  @StreamListener(MessageActorStream.ACTOR_SAVED)
  public void savedActor(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Received saved info " + actorMessage));
  }

  @StreamListener(MessageActorStream.ACTOR_DELETED)
  public void deletedActor(@Payload Boolean status) {
    runAsync(() -> log.info("Received deleted info " + status));
  }

  @StreamListener(MessageActorStream.ACTOR_READY_READ)
  public void receivedActor(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Received actor " + actorMessage));
  }
}
