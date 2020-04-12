package com.tfg.movies.back.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prize {

  @Id
  @Column(nullable = false)
  private String name;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate concessionDate;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "prizes")
  private Set<Movie> movies = new HashSet<>();

}
