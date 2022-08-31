package ru.ch.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ch.airport.service.aircraft.AircraftMapper;
import ru.ch.airport.service.aircraft.AircraftService;
import ru.ch.airport.service.aircraft.AircraftServiceImpl;
import ru.ch.airport.service.airport.AirportMapper;
import ru.ch.airport.service.airport.AirportService;
import ru.ch.airport.service.airport.DatabaseAirportServiceImpl;
import ru.ch.airport.service.tickets.TicketsCrudRepository;
import ru.ch.airport.service.tickets.TicketsMapper;
import ru.ch.airport.service.tickets.TicketsService;
import ru.ch.airport.service.tickets.TicketsServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public AirportService airportService(AirportMapper airportMapper) {
        return new DatabaseAirportServiceImpl( airportMapper);
    }

    @Bean
    public AircraftService aircraftService(AircraftMapper aircraftMapper) {
        return new AircraftServiceImpl (aircraftMapper);
    }
    @Bean
    public TicketsService ticketsService(TicketsMapper ticketsMapper) {
        return  new TicketsServiceImpl(ticketsMapper);
    }
}
