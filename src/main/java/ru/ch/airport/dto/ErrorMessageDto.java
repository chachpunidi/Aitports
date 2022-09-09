package ru.ch.airport.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Модель ошибки приложения")
public class ErrorMessageDto {
    private String application;
    private String code;
    private String message;
}
