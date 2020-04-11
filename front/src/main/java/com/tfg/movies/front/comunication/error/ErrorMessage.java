package com.tfg.movies.front.comunication.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ErrorMessage {

  private String error;

  public ErrorMessage withError(String error) {
    this.error = error;
    return this;
  }
}
