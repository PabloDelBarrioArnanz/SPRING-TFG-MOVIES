package com.tfg.movies.front.comunication.actor;

import com.tfg.movies.front.model.entity.Actor;
import com.tfg.movies.front.service.mapper.ActorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Component
public class ActorSender {

  @Autowired private ActorStream actorStream;
  @Autowired private ActorMapper actorMapper;

  public void sendMessageActorToSave(@Validated Actor actor) {
    log.info("Sending an actor for save :: " + actor);
    Optional.of(actor)
      .map(mov -> actorMapper.toActorMessage(mov))
      .ifPresent(message -> sendMessage(actorStream.sendRequestToSaveActor(), message));
  }

  public void sendMessageActorToRead(String title) {
    log.info("Sending a name to read the actor :: " + title);
    sendMessage(actorStream.sendRequestToReadActor(), title);
  }

  public void sendMessageActorsToRead() {
    log.info("Sending a request to read :: all actors");
    sendMessage(actorStream.sendRequestToReadAllActors(), "");
  }

  public void sendMessageActorsToDelete(String title) {
    log.info("Sending a name to delete actor :: " + title);
    sendMessage(actorStream.sendRequestToDeleteActor(), title);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
