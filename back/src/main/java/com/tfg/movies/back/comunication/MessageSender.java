package com.tfg.movies.back.comunication;

import com.tfg.movies.back.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageSender {

  @Autowired
  private MessageStream messageStream;

  public void sendMessageMovieSaved(Boolean status) {
    log.info("Saving movie process status :: " + status);
    sendMessage(messageStream.outboundSaved(), status);
  }

  public void sendMessageMoviesRead(List<Message> messages) {
    log.info("Reading all movies");
    sendMessage(messageStream.outboundsRead(), messages);
  }

  public void sendMessageMoviesReadByTitle(List<Message> messages) {
    log.info("Reading movies by title");
    sendMessage(messageStream.outboundsRead(), messages);
  }

  public void sendMessageMovieDeleted(Boolean status) {
    log.info("Deleting movie process status :: " + status);
    sendMessage(messageStream.outboundSaved(), status);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }

}
