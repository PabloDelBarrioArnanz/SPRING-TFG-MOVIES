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
public class DirectorSender {

  @Autowired private DirectorStream directorStream;
  @Autowired private DirectorMapper directorMapper;

  public void sendMessageDirectorToSave(@Validated Director director) {
    log.info("Sending a director for save :: " + director);
    Optional.of(director)
      .map(mov -> directorMapper.toDirectorMessage(mov))
      .ifPresent(message -> sendMessage(directorStream.sendRequestToSaveDirector(), message));
  }

  public void sendMessageDirectorToRead(String name) {
    log.info("Sending a name to read the director :: " + name);
    sendMessage(directorStream.sendRequestToReadDirector(), name);
  }

  public void sendMessageDirectorsToRead() {
    log.info("Sending a request to read :: all directors");
    sendMessage(directorStream.sendRequestToReadAllDirectors(), "");
  }

  public void sendMessageDirectorsToDelete(String name) {
    log.info("Sending a name to delete director :: " + name);
    sendMessage(directorStream.sendRequestToDeleteDirector(), name);
  }

  private <T> void sendMessage(MessageChannel channel, T payload) {
    channel
      .send(MessageBuilder
        .withPayload(payload)
        .build());
  }
}
