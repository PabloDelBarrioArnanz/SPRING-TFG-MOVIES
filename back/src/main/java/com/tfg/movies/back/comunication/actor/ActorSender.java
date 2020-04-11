package com.tfg.movies.back.comunication.actor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class ActorSender {

  @Autowired private ActorStream actorStream;

  public boolean sendMessageActorSaved(ActorMessage actorMessage) {
    log.info("Sending save actor response :: " + actorMessage);
    return sendMessage(actorStream.sendSaveActorResponse(), actorMessage);
  }

  public boolean sendMessageActorRead(ActorMessage messages) {
    log.info("Sending read actor response :: " + messages);
    return sendMessage(actorStream.sendReadActorResponse(), messages);
  }

  public boolean sendMessageActorDeleted(Boolean result) {
    log.info("Sending delete actor response :: " + result);
    return sendMessage(actorStream.sendDeleteActorResponse(), result);
  }

  @Transactional
  public <T> boolean sendMessage(MessageChannel channel, T payload) {
    return channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }

}
