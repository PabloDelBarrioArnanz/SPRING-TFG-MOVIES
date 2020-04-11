package com.tfg.movies.back.comunication;

import com.tfg.movies.back.comunication.actor.MessageActorStream;
import com.tfg.movies.back.comunication.director.MessageDirectorStream;
import com.tfg.movies.back.comunication.error.MessageErrorStream;
import com.tfg.movies.back.comunication.movie.MessageMovieStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({MessageMovieStream.class, MessageActorStream.class, MessageDirectorStream.class, MessageErrorStream.class})
public class ConfigCommunication {
}
