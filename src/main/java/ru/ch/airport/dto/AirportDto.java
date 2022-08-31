package ru.ch.airport.dto;

import lombok.Data;


@Data
public class AirportDto {
    private String code;
    private String name;
    private String city;
    private Float longitude;
    private Float latitude;
    private String timezone;

}
