package com.tfg.movies.back.comunication.actor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class MessageActorSender {

  @Autowired private MessageActorStream messageActorStream;

  public void sendMessageActorSaved(ActorMessage actorMessage) {
    log.info("Saving actor :: " + actorMessage);
    sendMessage(messageActorStream.outboundSaved(), actorMessage);
  }

  public void sendMessageActorsRead(ActorMessage messages) {
    log.info("Reading all actors");
    sendMessage(messageActorStream.outboundsRead(), messages);
  }

  public void sendMessageActorsReadByTitle(ActorMessage messages) {
    log.info("Reading actors by title " + messages);
    sendMessage(messageActorStream.outboundsRead(), messages);
  }

  public void sendMessageActorDeleted(Boolean result) {
    log.info("Deleting actor :: " + result);
    sendMessage(messageActorStream.outboundDeleted(), result);
  }

  @Transactional
  public <T> void sendMessage(MessageChannel channel, T payload) {
    channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }

}
