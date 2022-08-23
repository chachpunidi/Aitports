package ru.ch.airport.service.tickets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ch.airport.dto.AircraftDto;
import ru.ch.airport.dto.TicketsDto;

@Repository
public interface TicketsCrudRepository extends PagingAndSortingRepository<TicketsDto, String> {
}
