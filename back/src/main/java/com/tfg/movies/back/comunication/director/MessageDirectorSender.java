package com.tfg.movies.back.comunication.director;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
public class MessageDirectorSender {

  @Autowired private MessageDirectorStream messageDirectorStream;

  public void sendMessageDirectorSaved(DirectorMessage directorMessage) {
    log.info("Saving director :: " + directorMessage);
    sendMessage(messageDirectorStream.outboundSaved(), directorMessage);
  }

  public void sendMessageDirectorsRead(DirectorMessage messages) {
    log.info("Reading all directors");
    sendMessage(messageDirectorStream.outboundsRead(), messages);
  }

  public void sendMessageDirectorsReadByTitle(DirectorMessage messages) {
    log.info("Reading directors by title " + messages);
    sendMessage(messageDirectorStream.outboundsRead(), messages);
  }

  public void sendMessageDirectorDeleted(Boolean result) {
    log.info("Deleting director :: " + result);
    sendMessage(messageDirectorStream.outboundDeleted(), result);
  }

  @Transactional
  public <T> void sendMessage(MessageChannel channel, T payload) {
    channel.send(MessageBuilder
      .withPayload(payload)
      .build());
  }

}
