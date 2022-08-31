package ru.ch.airport.service.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ch.airport.dto.AirportDto;
import ru.ch.airport.dto.TicketsDto;

import java.util.ArrayList;
import java.util.List;



public class TicketsServiceImpl implements TicketsService {

    private TicketsMapper ticketsMapper;

    @Autowired
    public TicketsServiceImpl(TicketsMapper ticketsMapper) { this.ticketsMapper = ticketsMapper;}



    @Override
    public List<TicketsDto> findTickets(Integer limit, Integer offset) {

        return ticketsMapper.findAll(limit, offset);
    };

    @Override
    public TicketsDto findTicket(String ticketNo) {

        return ticketsMapper.findByCode(ticketNo);
    }

    @Override
    public Integer createTicket(TicketsDto ticket) {
       Integer x = ticketsMapper.save(ticket);
        return x;
    }

    public Integer createTickets(List<TicketsDto> tickets) {
        int rec = 0;
        for(TicketsDto ticket: tickets) {
            TicketsDto foudeTicket = findTicket(ticket.getTicketNo());
            if (foudeTicket != null) {
                throw new RuntimeException();
            }
            Integer operationCount = ticketsMapper.save(ticket);
            rec = rec + operationCount;

        }
        return  rec;
    }

    @Override
    public Integer updateTicket(String ticketNo , TicketsDto ticket) {
        Integer x = ticketsMapper.update(ticketNo, ticket );
        return x;

    }

    @Override
    public Integer deleteTickets(String ticketNo) {
        Integer x = ticketsMapper.delete(ticketNo);
        return x;
    }
}


