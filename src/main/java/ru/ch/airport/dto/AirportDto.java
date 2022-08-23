package ru.ch.airport.dto;

import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "airports")
public class AirportDto {
    @Id
    @Column(name = "airport_code")
    private String code;
    @Column(name = "airport_name")
    private String name;
    private String city;
    private Float longitude;
    private Float latitude;
    private String timezone;

}
