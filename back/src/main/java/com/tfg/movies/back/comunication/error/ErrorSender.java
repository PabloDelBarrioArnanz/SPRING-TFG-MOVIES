package com.tfg.movies.back.comunication.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorSender {

  @Autowired private ErrorStream errorStream;

  public boolean sendMessageError(ErrorMessage error) {
    log.info("Sending an error" + error);
    return sendMessage(errorStream.sendError(), error);
  }

  private <T> boolean sendMessage(MessageChannel channel, T payload) {
    return channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
