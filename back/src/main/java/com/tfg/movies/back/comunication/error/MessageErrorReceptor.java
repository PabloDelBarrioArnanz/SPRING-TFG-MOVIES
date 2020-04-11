package com.tfg.movies.back.comunication.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.util.concurrent.CompletableFuture.runAsync;

@Slf4j
@Component
public class MessageErrorReceptor {

  @StreamListener(MessageErrorStream.ERROR_RESPONSE)
  public void savedActor(@Payload ErrorMessage errorMessage) {
    runAsync(() -> log.error(errorMessage.getError()));
  }
}
