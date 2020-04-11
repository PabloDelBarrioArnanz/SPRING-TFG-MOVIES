package com.tfg.movies.back.repository;

import com.tfg.movies.back.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {
  List<Actor> findAll();
  Actor findByName(String name);
  void delete(Actor actor);
}
