package ru.ch.airport.service.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ch.airport.dto.AircraftDto;
import ru.ch.airport.dto.AirportDto;

@Repository
public interface AircraftCrudRepository extends CrudRepository<AircraftDto, String> {
}
