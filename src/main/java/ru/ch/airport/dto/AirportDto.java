package ru.ch.airport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Модель данных аэропорта")
public class AirportDto {
    @Schema(description = "Код аэропорта", example = "MCX")
    private String code;

    @Schema(description = "Название аэропорта", example = "Уйташ")
    private String name;

    @Schema(description = "Город аэропорта", example = "Махачкала")
    private String city;

    @Schema(description = " Координаты аэропорта: долгота", example = "47.652294")
    private Float longitude;

    @Schema(description = "  Координаты аэропорта: широта", example = "42.816822")
    private Float latitude;

    @Schema(description = "Временная зона аэропорта", example = "Europe/Moscow")
    private String timezone;

}
