package ru.ch.airport.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@Entity
public class AirportDto {
    @Id
    @GeneratedValue
    private String code;
    private String name;
    private String city;
    private Float longitude;
    private Float latitude;
    private String timezone;

}
