package com.tfg.movies.front.comunication.director;

import com.tfg.movies.front.model.entity.Director;
import com.tfg.movies.front.service.mapper.DirectorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Slf4j
@Component
public class MessageDirectorSender {

  @Autowired private MessageDirectorStream messageDirectorStream;
  @Autowired private DirectorMapper directorMapper;

  public void sendMessageDirectorToSave(@Validated Director director) {
    log.info("Sending a director to be saved " + director);
    Optional.of(director)
      .map(mov -> directorMapper.toDirectorMessage(mov))
      .ifPresent(message -> sendMessage(messageDirectorStream.sendRequestToSaveDirector(), message));
  }

  public void sendMessageDirectorToRead(String title) {
    log.info("Sending a name to read the director " + title);
    sendMessage(messageDirectorStream.sendRequestToReadDirector(), title);
  }

  public void sendMessageDirectorsToRead() {
    log.info("Sending a request to read all director");
    sendMessage(messageDirectorStream.sendRequestToReadAllDirectors(), "");
  }

  public void sendMessageDirectorsToDelete(String title) {
    log.info("Sending a name to delete director " + title);
    sendMessage(messageDirectorStream.sendRequestToDeleteDirector(), title);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
