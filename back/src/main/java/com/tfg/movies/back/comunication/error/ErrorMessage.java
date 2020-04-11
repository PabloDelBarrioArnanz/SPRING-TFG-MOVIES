package com.tfg.movies.back.comunication.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

  private String error;

  public ErrorMessage withError(String error) {
    this.error = error;
    return this;
  }
}
