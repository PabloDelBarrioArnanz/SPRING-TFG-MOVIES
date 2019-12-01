package com.tfg.movies.back.comunication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageSender {

  @Autowired private MessageStream messageStream;

  public void sendMessageMovieSaved(Message message) {
    log.info("Saving movie :: " + message);
    sendMessage(messageStream.outboundSaved(), message);
  }

  public void sendMessageMoviesRead(List<Message> messages) {
    log.info("Reading all movies");
    sendMessage(messageStream.outboundsRead(), messages);
  }

  public void sendMessageMoviesReadByTitle(List<Message> messages) {
    log.info("Reading movies by title " + messages);
    sendMessage(messageStream.outboundsRead(), messages);
  }

  public void sendMessageMovieDeleted(Boolean result) {
    log.info("Deleting movie :: " + result);
    sendMessage(messageStream.outboundSaved(), result);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }

}
