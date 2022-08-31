package ru.ch.airport.dto;

import lombok.Data;

@Data
public class TicketsDto {
    private String ticketNo;
    private String bookRef;
    private String passengerId;
    private String passengerName;
    private String contactData;

}
