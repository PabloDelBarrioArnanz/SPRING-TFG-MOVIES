package com.tfg.movies.front.comunication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSender {

  @Autowired private MessageStream messageStream;

  public void sendMessageMovieToSave(Message message) {
    log.info("Sending a movie to be saved " + message);
    sendMessage(messageStream.outboundToSave(), message);
  }

  public void sendMessageMovieToRead(String tittle) {
    log.info("Sending a tittle to read the movie " + tittle);
    sendMessage(messageStream.outboundToRead(), tittle);
  }

  public void sendMessageMoviesToRead() {
    log.info("Sending a request to read all movies");
    sendMessage(messageStream.outboundsToRead(), "");
  }

  public void sendMessageMoviesToDelete(String tittle) {
    log.info("Sending a tittle to delete movie " + tittle);
    sendMessage(messageStream.outboundToDelete(), tittle);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }

}
