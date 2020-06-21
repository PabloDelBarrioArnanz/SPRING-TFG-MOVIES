package com.tfg.movies.back.comunication.director;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class DirectorSender {

  @Autowired private DirectorStream directorStream;

  public boolean sendMessageDirectorSaved(DirectorMessage directorMessage) {
    log.info("Sending save director response :: " + directorMessage);
    return sendMessage(directorStream.sendSaveDirectorResponse(), directorMessage);
  }

  public boolean sendMessageDirectorRead(DirectorMessage messages) {
    log.info("Sending read director response :: " + messages);
    return sendMessage(directorStream.sendReadDirectorResponse(), messages);
  }

  public boolean sendMessageDirectorDeleted(Boolean result) {
    log.info("Sending delete director response :: " + result);
    return sendMessage(directorStream.sendDeleteDirectorResponse(), result);
  }

  @Transactional
  public <T> boolean sendMessage(MessageChannel channel, T payload) {
    return channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }

}
