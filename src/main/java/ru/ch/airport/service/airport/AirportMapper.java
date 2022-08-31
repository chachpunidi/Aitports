package ru.ch.airport.service.airport;

import org.apache.ibatis.annotations.Mapper;

import ru.ch.airport.dto.AirportDto;

import java.util.List;

@Mapper
public interface AirportMapper {



    AirportDto findByCode(String code);

    Integer save(AirportDto airport);

    Iterable<AirportDto> saveAll(List<AirportDto> airports);


    Integer delete(String code);

    Integer update(String code, AirportDto airport);

    List<AirportDto> findAll();
}
