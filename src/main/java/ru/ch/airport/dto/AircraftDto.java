package ru.ch.airport.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aircrafts")
public class AircraftDto {
    @Id
    @Column(name = "aircraft_code")
    private String code;
    @Transient
    private String manufacturer;
    private String model;
    private Long range;
}
