package com.tfg.movies.front.comunication.movie;

import com.tfg.movies.front.model.entity.Movie;
import com.tfg.movies.front.service.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class MovieSender {

  private final MovieStream movieStream;
  private final MovieMapper movieMapper;

  public void sendMessageMovieToSave(@Validated MovieMessage movieMessage) {
    log.info("Sending a movie for save :: " + movieMessage.getMovie());
    Optional.of(movieMessage)
      .ifPresent(message -> sendMessage(movieStream.sendRequestToSaveMovie(), message));
  }

  public void sendMessageMovieToRead(String title) {
    log.info("Sending a title to read the movie :: " + title);
    sendMessage(movieStream.sendRequestToReadMovie(), title);
  }

  public void sendMessageMoviesToRead(Boolean sort) {
    log.info("Sending a request to read :: all movies");
    sendMessage(movieStream.sendRequestToSaveAllMovies(), sort);
  }

  public void sendMessageMoviesToDelete(String title) {
    log.info("Sending a title to delete movie :: " + title);
    sendMessage(movieStream.sendRequestToDeleteMovie(), title);
  }

  public void sendMessageMoviesToVote(Movie movieToVote) {
    log.info("Sending a title to vote movie :: " + movieToVote.getTitle() + " -> " + movieToVote.getVote());
    Optional.of(movieToVote)
      .map(mov -> movieMapper.toMovieMessage(mov))
      .ifPresent(message -> sendMessage(movieStream.sendRequestToVoteMovie(), message));
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
