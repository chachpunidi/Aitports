package ru.ch.airport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Модель данных билетов")
public class TicketsDto {
    @Schema(description = "Номер билета", example = "MCX")
    private String ticketNo;

    @Schema(description = "Номер бронирования", example = "MCX")
    private String bookRef;

    @Schema(description = "Индетификатор пассажира", example = "MCX")
    private String passengerId;

    @Schema(description = "Имя пассажира", example = "MCX")
    private String passengerName;

    @Schema(description = "Контактные данные пассажира", example = "MCX")
    private String contactData;

}
