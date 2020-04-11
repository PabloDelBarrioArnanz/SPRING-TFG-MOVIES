package com.tfg.movies.back.comunication.director;

import com.tfg.movies.back.model.dto.DirectorDTO;
import com.tfg.movies.back.model.entity.Director;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class DirectorMessage {

  private Director director;
  private DirectorDTO directorDTO;

  public DirectorMessage withDirector(Director director) {
    this.director = director;
    return this;
  }

  public DirectorMessage withDirectorDTO(DirectorDTO directorDTO) {
    this.directorDTO = directorDTO;
    return this;
  }
}
