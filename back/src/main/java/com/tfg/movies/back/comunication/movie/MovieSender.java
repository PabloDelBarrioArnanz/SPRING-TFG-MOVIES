package com.tfg.movies.back.comunication.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovieSender {

  @Autowired private MovieStream movieStream;

  public boolean sendMessageMovieSaved(MovieMessage movieMessage) {
    log.info("Sending saved movie response :: " + movieMessage.getMovieDTO());
    return sendMessage(movieStream.sendSaveMovieResponse(), movieMessage);
  }

  public boolean sendMessageMovieRead(MovieMessage message) {
    log.info("Sending read movie response :: " + message.getMovieDTO());
    return sendMessage(movieStream.sendReadMovieResponse(), message);
  }

  public boolean sendMessageMovieDeleted(Boolean result) {
    log.info("Sending delete movie response :: " + result);
    return sendMessage(movieStream.sendDeleteMovieResponse(), result);
  }

  public <T> boolean sendMessage(MessageChannel channel, T payload) {
    return channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }
}
