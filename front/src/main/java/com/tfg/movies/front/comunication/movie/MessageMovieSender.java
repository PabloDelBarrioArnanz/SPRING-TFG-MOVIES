package com.tfg.movies.front.comunication.movie;

import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Component
public class MessageMovieSender {

  @Autowired private MessageMovieStream messageMovieStream;
  @Autowired private MovieMapper movieMapper;

  public void sendMessageMovieToSave(@Validated Movie movie) {
    log.info("Sending a movie to be saved " + movie);
    Optional.of(movie)
      .map(mov -> movieMapper.toMovieMessage(mov))
      .ifPresent(message -> sendMessage(messageMovieStream.sendRequestToSaveMovie(), message));
  }

  public void sendMessageMovieToRead(String title) {
    log.info("Sending a tittle to read the movie " + title);
    sendMessage(messageMovieStream.sendRequestToReadMovie(), title);
  }

  public void sendMessageMoviesToRead() {
    log.info("Sending a request to read all movies");
    sendMessage(messageMovieStream.sendRequestToSaveAllMovies(), "");
  }

  public void sendMessageMoviesToDelete(String title) {
    log.info("Sending a tittle to delete movie " + title);
    sendMessage(messageMovieStream.sendRequestToDeleteMovie(), title);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
