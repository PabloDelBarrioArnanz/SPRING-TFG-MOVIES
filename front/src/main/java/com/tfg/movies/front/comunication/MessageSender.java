package com.tfg.movies.front.comunication;

import com.tfg.movies.front.mapper.MoviesMapper;
import com.tfg.movies.front.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Component
public class MessageSender {

  @Autowired private MessageStream messageStream;
  @Autowired private MoviesMapper moviesMapper;

  public void sendMessageMovieToSave(@Validated Movie movie) {
    log.info("Sending a movie to be saved " + movie);
    Message message = moviesMapper.toMessage(movie);
    sendMessage(messageStream.outboundToSave(), message);
  }

  public void sendMessageMovieToRead(String title) {
    log.info("Sending a tittle to read the movie " + title);
    sendMessage(messageStream.outboundToRead(), title);
  }

  public void sendMessageMoviesToRead() {
    log.info("Sending a request to read all movies");
    sendMessage(messageStream.outboundsToRead(), "");
  }

  public void sendMessageMoviesToDelete(String title) {
    log.info("Sending a tittle to delete movie " + title);
    sendMessage(messageStream.outboundToDelete(), title);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }

}
