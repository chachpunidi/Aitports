package ru.ch.airport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Модель данных самолета")
public class AircraftDto {
    @Schema(description = "Код самолета", example = "773")
    private String code;

    @Schema(description = "Производитеть самолета", example = "Boieng")
    private String manufacturer;

    @Schema(description = "Модель самолета", example = "Boeing 777-300")
    private String model;

    @Schema(description = "Максимальная дальность полета самолета, км", example = "11100")
    private Long range;
}
