package com.tfg.movies.front.comunication.director;

import com.tfg.movies.front.model.dto.DirectorDTO;
import com.tfg.movies.front.model.entity.Director;
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
}
