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
public class MessageActorSender {

  @Autowired private MessageActorStream messageActorStream;
  @Autowired private ActorMapper actorMapper;

  public void sendMessageActorToSave(@Validated Actor actor) {
    log.info("Sending a actor to be saved " + actor);
    Optional.of(actor)
      .map(mov -> actorMapper.toActorMessage(mov))
      .ifPresent(message -> sendMessage(messageActorStream.sendRequestToSaveActor(), message));
  }

  public void sendMessageActorToRead(String title) {
    log.info("Sending a name to read the actor " + title);
    sendMessage(messageActorStream.sendRequestToReadActor(), title);
  }

  public void sendMessageActorsToRead() {
    log.info("Sending a request to read all actor");
    sendMessage(messageActorStream.sendRequestToReadAllActors(), "");
  }

  public void sendMessageActorsToDelete(String title) {
    log.info("Sending a name to delete actor " + title);
    sendMessage(messageActorStream.sendRequestToDeleteActor(), title);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
