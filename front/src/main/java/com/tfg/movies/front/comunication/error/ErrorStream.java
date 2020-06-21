package com.tfg.movies.front.comunication.error;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ErrorStream {

  String ERROR_RESPONSE = "ERROR_RESPONSE";
  String ERROR_REQUEST = "ERROR_REQUEST";


  @Input(ERROR_RESPONSE)
  SubscribableChannel getError();

  @Output(ERROR_REQUEST)
  MessageChannel sendError();

}
