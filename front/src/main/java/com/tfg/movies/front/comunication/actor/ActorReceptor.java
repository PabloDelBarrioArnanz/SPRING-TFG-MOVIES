package com.tfg.movies.front.comunication.actor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class ActorReceptor {

  @StreamListener(ActorStream.SAVE_ACTOR_RESPONSE)
  public void savedActor(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Actor save response :: " + actorMessage.getActorDTO()));
  }

  @StreamListener(ActorStream.DELETE_ACTOR_RESPONSE)
  public void deletedActor(@Payload Boolean status) {
    runAsync(() -> log.info("Actor deleted response :: " + status));
  }

  @StreamListener(ActorStream.READ_ACTOR_RESPONSE)
  public void receivedActor(@Payload ActorMessage actorMessage) {
    runAsync(() -> log.info("Movie read request info :: " + actorMessage.getActorDTO()));
  }
}
