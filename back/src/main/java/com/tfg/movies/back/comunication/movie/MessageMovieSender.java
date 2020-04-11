package com.tfg.movies.back.comunication.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageMovieSender {

  @Autowired
  private MessageMovieStream messageMovieStream;

  public boolean sendMessageMovieSaved(MovieMessage movieMessage) {
    log.info("Saving movie :: " + movieMessage);
    return sendMessage(messageMovieStream.outboundSaved(), movieMessage);
  }

  public boolean sendMessageMoviesRead(MovieMessage messages) {
    log.info("Reading all movies");
    return sendMessage(messageMovieStream.outboundsRead(), messages);
  }

  public boolean sendMessageMoviesReadByTitle(MovieMessage messages) {
    log.info("Reading movies by title " + messages);
    return sendMessage(messageMovieStream.outboundsRead(), messages);
  }

  public boolean sendMessageMovieDeleted(Boolean result) {
    log.info("Deleting movie :: " + result);
    return sendMessage(messageMovieStream.outboundDeleted(), result);
  }

  public <T> boolean sendMessage(MessageChannel channel, T payload) {
    return channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }

}
