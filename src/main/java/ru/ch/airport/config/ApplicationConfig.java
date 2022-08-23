package ru.ch.airport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ch.airport.service.aircraft.AircraftCrudRepository;
import ru.ch.airport.service.aircraft.AircraftService;
import ru.ch.airport.service.aircraft.AircraftServiceImpl;
import ru.ch.airport.service.airport.*;
import ru.ch.airport.service.tickets.TicketsCrudRepository;
import ru.ch.airport.service.tickets.TicketsService;
import ru.ch.airport.service.tickets.TicketsServiceImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public AirportService airportService(AirportCrudRepository airportCrudRepository) {
        return new DatabaseAirportServiceImpl(airportCrudRepository);
    }

    @Bean
    public AircraftService aircraftService(AircraftCrudRepository aircraftCrudRepository) {
        return new AircraftServiceImpl (aircraftCrudRepository);
    }
    @Bean
    public TicketsService ticketsService(TicketsCrudRepository ticketsCrudRepository) {
        return  new TicketsServiceImpl(ticketsCrudRepository);
    }
}
