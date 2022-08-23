package ru.ch.airport.service.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.ch.airport.SqlConsumer;
import ru.ch.airport.dto.AircraftDto;
import ru.ch.airport.dto.AirportDto;
import ru.ch.airport.dto.TicketsDto;
import ru.ch.airport.service.airport.AirportCrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsServiceImpl implements TicketsService {

    private TicketsCrudRepository ticketsCrudRepository;

    @Autowired
    public TicketsServiceImpl(TicketsCrudRepository ticketsCrudRepository) {
        this.ticketsCrudRepository = ticketsCrudRepository;
    }
    @Override
    public List<TicketsDto> findTickets(Integer page, Integer size) {
        List<TicketsDto> ticketsList = new ArrayList<>();
      Iterable<TicketsDto> ticketIterable = ticketsCrudRepository.findAll(PageRequest.of(page, size));
      ticketIterable.forEach(ticketsList::add);

        return ticketsList;
 }

    @Override
    public TicketsDto findTicket(String ticketNo) {
       TicketsDto ticket = ticketsCrudRepository.findById(ticketNo).orElse(null);

       return ticket;
    }

    @Override
    public Integer createTicket(TicketsDto ticket) {
        ticketsCrudRepository.save(ticket);
        return 1;
    }


    public Integer createTickets(List<TicketsDto> tickets) {
       List<TicketsDto> target = new ArrayList<>();
       Iterable<TicketsDto> returnTickets = ticketsCrudRepository.saveAll(tickets);
       returnTickets.forEach(target::add);
       return target.size();
        }



    @Override
    public Integer updateTicket(String ticketNo , TicketsDto ticket) {
    ticket.setTicketNo(ticketNo);
    ticketsCrudRepository.save(ticket);
    return 1;

    }

    @Override
    public Integer deleteTickets(String ticketNo) {
        ticketsCrudRepository.deleteById(ticketNo);
        return 1;
    }
    }


