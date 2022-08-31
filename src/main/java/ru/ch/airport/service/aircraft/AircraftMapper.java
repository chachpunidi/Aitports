package ru.ch.airport.service.aircraft;

import org.apache.ibatis.annotations.Mapper;
import ru.ch.airport.dto.AircraftDto;

import java.util.List;

@Mapper
public interface AircraftMapper {
    List<AircraftDto> findAll();

    AircraftDto findByCode(String code);

    Integer save(AircraftDto aircraft);

    Integer delete(String code);

    Iterable<AircraftDto> saveAll(List<AircraftDto> aircrafts);

    Integer update(String code, AircraftDto aircraft);
}
