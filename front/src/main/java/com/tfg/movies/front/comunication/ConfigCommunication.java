package com.tfg.movies.front.comunication;

import com.tfg.movies.front.comunication.actor.ActorStream;
import com.tfg.movies.front.comunication.director.DirectorStream;
import com.tfg.movies.front.comunication.error.ErrorStream;
import com.tfg.movies.front.comunication.movie.MovieStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MovieStream.class, ActorStream.class, ErrorStream.class, DirectorStream.class})
public class ConfigCommunication {
}
