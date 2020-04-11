package com.tfg.movies.front.comunication.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageErrorSender {

  @Autowired private MessageErrorStream messageErrorStream;

  public void sendMessageError(String error) {
    log.info("Sending an error" + error);
    sendMessage(messageErrorStream.sendError(), error);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
