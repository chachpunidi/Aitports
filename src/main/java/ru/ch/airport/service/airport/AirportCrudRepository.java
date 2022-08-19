package ru.ch.airport.service.airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ch.airport.dto.AirportDto;

@Repository
public interface AirportCrudRepository extends CrudRepository<AirportDto, String> {


}