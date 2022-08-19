package ru.ch.airport.dto;

import lombok.Data;

@Data
public class AircraftDto {

    private String code;
    private String manufacturer;
    private String model;
    private Long range;
}
