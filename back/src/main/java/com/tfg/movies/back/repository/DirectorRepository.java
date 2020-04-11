package com.tfg.movies.back.repository;

import com.tfg.movies.back.model.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
  List<Director> findAll();
  List<Director> findByName(String name);
  Integer deleteByName(String name);
}
