package com.tfg.movies.back.comunication;

import com.tfg.movies.back.comunication.actor.ActorStream;
import com.tfg.movies.back.comunication.director.DirectorStream;
import com.tfg.movies.back.comunication.error.ErrorStream;
import com.tfg.movies.back.comunication.movie.MovieStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MovieStream.class, ActorStream.class, DirectorStream.class, ErrorStream.class})
public class ConfigCommunication {
}
