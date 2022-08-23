package ru.ch.airport.dto;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "tickets")
public class TicketsDto {
    @Id
    @Column(name = "ticket_no")
    private String ticketNo;

    @Column(name = "book_ref")
    private String bookRef;

    @Column(name = "passenger_id")
    private String passengerId;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "contact_data")
    private String contactData;

}
