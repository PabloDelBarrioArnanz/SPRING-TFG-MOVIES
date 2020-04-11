package com.tfg.movies.front.comunication;

import com.tfg.movies.front.comunication.actor.MessageActorStream;
import com.tfg.movies.front.comunication.director.MessageDirectorStream;
import com.tfg.movies.front.comunication.error.MessageErrorStream;
import com.tfg.movies.front.comunication.movie.MessageMovieStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MessageMovieStream.class, MessageActorStream.class, MessageErrorStream.class, MessageDirectorStream.class})
public class ConfigCommunication {
}
