package com.tfg.movies.front.service.mapper;

import com.tfg.movies.front.comunication.director.DirectorMessage;
import com.tfg.movies.front.model.dto.DirectorDTO;
import com.tfg.movies.front.model.entity.Director;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DirectorMapper {

  public DirectorMessage toDirectorMessage(Director director) {
    return new DirectorMessage().withDirector(director);
  }

  public DirectorMessage toDirectorMessage(String name) {
    DirectorMessage directorMessage = new DirectorMessage();
    Optional.of(new Director())
      .map(director -> director.setName(name))
      .ifPresent(directorMessage::withDirector);

    return directorMessage;
  }

  public Director toDirector(DirectorMessage directorMessage) {
    return directorMessage.getDirector();
  }

  public DirectorDTO toDirectorDTO(DirectorMessage directorMessage) {
    return directorMessage.getDirectorDTO();
  }

}
