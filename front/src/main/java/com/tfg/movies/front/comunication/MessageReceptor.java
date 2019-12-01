package com.tfg.movies.front.comunication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageReceptor {

  @StreamListener(MessageStream.MOVIE_SAVED)
  public void savedMovie(@Payload Message message) {
    log.info("Received saved info " + message);
  }

  @StreamListener(MessageStream.MOVIE_DELETED)
  public void deletedMovie(@Payload Boolean status) {
    log.info("Received deleted info " + status);
  }

  @StreamListener(MessageStream.MOVIES_READY_READ)
  public void receivedMovies(@Payload List<Message> messages) {
    log.info("Received movies " + messages);
  }

}
