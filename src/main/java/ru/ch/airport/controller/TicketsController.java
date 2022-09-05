package ru.ch.airport.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ch.airport.dto.TicketsDto;
import ru.ch.airport.service.tickets.TicketsService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@Tag(name = "Контроллер для работы с билетами")
public class TicketsController {

    private TicketsService ticketsService;

    @Autowired
    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @Operation(description = "Получить список билетов", summary = "Получить список билетов")
    @GetMapping
    public List<TicketsDto> tickets(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
        return ticketsService.findTickets(limit, offset);
    }


    @Operation(description = "Получить билет по номеру", summary = "Получить билет по номеру")
    @GetMapping("/{ticketNo}")
    public TicketsDto ticket(
            @Parameter(description = "Номер билета", example = "NBC")
            @PathVariable(value = "ticketNo")
            String ticketNo
    ) {
        return ticketsService.findTicket(ticketNo);
    }


    @Operation(description = "Создание билета", summary = "Создание билета")
    @PutMapping
    public Integer createTicket(@RequestBody TicketsDto ticket) {

        return  ticketsService.createTicket(ticket);
    }
    @Operation(description = "Создание списка билетов", summary = "Создание списка билетов")
    @PutMapping("/batch")
    public Integer createTickets(@RequestBody List<TicketsDto> tickets) {

        return ticketsService.createTickets(tickets);
    }


    @Operation(description = "Обновить билет по коду", summary = "Обновить билет по коду")
    @PatchMapping("/{ticketNo}")
    public Integer updateTickets(
            @Parameter(description = "Номер билета", example = "116")
            @PathVariable(value = "ticketNo")
            String ticketNo,
            @RequestBody TicketsDto ticket) {
    return     ticketsService.updateTicket(ticketNo, ticket);
    }


    @Operation(description = "Удалить  билет по номеру", summary = "Удалить  билет по номеру")
    @DeleteMapping("/{ticketNo}")
    public Integer deleteTickets(
            @Parameter(description = "Номер билета", example = "111")
            @PathVariable(value = "ticketNo")
            String ticketNo
    ) {
        return ticketsService.deleteTickets(ticketNo);
    }
}