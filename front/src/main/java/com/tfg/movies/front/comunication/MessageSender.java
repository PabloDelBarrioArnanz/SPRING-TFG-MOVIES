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

  public void sendMessageMovieToRead(Message message) {
    log.info("Sending a tittle to read the movie " + message);
    sendMessage(messageStream.outboundToRead(), message);
  }

  public void sendMessageMoviesToRead(Message message) {
    log.info("Sending a request to read all movies " + message);
    sendMessage(messageStream.outboundsToRead(), message);
  }

  public void sendMessageMoviesToDelete(Message message) {
    log.info("Sending a tittle to delete movie " + message);
    sendMessage(messageStream.outboundToDelete(), message);
  }

  private void sendMessage(MessageChannel channel, Message message) {
    channel
      .send(MessageBuilder
        .withPayload(message)
        .build());
  }

}
