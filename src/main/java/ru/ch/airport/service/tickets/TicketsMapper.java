package ru.ch.airport.service.tickets;

import org.apache.ibatis.annotations.Mapper;
import ru.ch.airport.dto.AirportDto;
import ru.ch.airport.dto.TicketsDto;

import java.util.List;
@Mapper
public interface TicketsMapper {
    List<TicketsDto> findAll(Integer limit, Integer offset);
    TicketsDto findByCode(String ticketNo);
    Integer save(TicketsDto ticket);

    Iterable<TicketsDto> saveAll(List<TicketsDto> tickets);

    Integer update(String ticketNo, TicketsDto ticket);

    Integer delete(String ticketNo);
}


