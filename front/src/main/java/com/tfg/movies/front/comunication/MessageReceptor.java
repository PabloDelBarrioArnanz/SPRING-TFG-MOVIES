package com.tfg.movies.front.comunication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageReceptor {

  @Autowired private MessageStream messageStream;

  @StreamListener(MessageStream.MOVIE_SAVED)
  public void savedMovie(@Payload Message message) {
    log.info("Received save info " + message);
  }

  @StreamListener(MessageStream.MOVIE_DELETED)
  public void deletedMovie(@Payload Message message) {
    log.info("Received deleted info " + message);
  }


  @StreamListener(MessageStream.MOVIE_TO_READ)
  public void receivedMovie(@Payload Message message) {
    log.info("Received movie " + message);
  }

  @StreamListener(MessageStream.MOVIES_TO_READ)
  public void receivedMovies(@Payload List<Message> messages) {
    log.info("Received movies " + messages);
  }

}
