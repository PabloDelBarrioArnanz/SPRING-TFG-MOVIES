package com.tfg.movies.back.comunication.director;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tfg.movies.back.model.dto.DirectorDTO;
import com.tfg.movies.back.model.entity.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirectorMessage {

  private Director director;
  private DirectorDTO directorDTO;

  public DirectorMessage withDirectorDTO(DirectorDTO directorDTO) {
    this.directorDTO = directorDTO;
    return this;
  }
}
