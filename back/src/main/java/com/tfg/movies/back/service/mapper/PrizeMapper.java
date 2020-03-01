package com.tfg.movies.back.service.mapper;

import com.tfg.movies.back.model.dto.PrizeDTO;
import com.tfg.movies.back.model.entity.Prize;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PrizeMapper {

  public Set<PrizeDTO> toPrizeDTO(Set<Prize> prizes) {
    return prizes.stream()
      .map(this::toPrizeDTO)
      .collect(Collectors.toSet());
  }

  public PrizeDTO toPrizeDTO(Prize prize) {
    return new PrizeDTO()
      .setName(prize.getName())
      .setConcessionDate(prize.getConcessionDate());
  }
}
