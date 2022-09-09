package ru.ch.airport.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ch.airport.dto.ErrorMessageDto;
import ru.ch.airport.exception.CodeNotExistException;
import ru.ch.airport.exception.HasCode;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private static final String APP_NAME = "airport-rs-spring-mybatis";

   @ApiResponse(
            responseCode = "422",
            description = "- Отсутствует роль СУБО. Тип AuthenticationException (meta.code: 403.1);" +
                    "- Не подключен пакет ПУ. Тип NoSuitablePackageException (meta.code: 403.0);" +
                    "- Не найден пакет ПУ \"Привилегия\" в прошлом. Тип NoSuitablePackageInPastException (meta.code: 403.3);",
            content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
  )
   @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessageDto> dataIntegrityViolationExceptionException(Exception ex) {
        ErrorMessageDto.ErrorMessageDtoBuilder messageBuilder = ErrorMessageDto.builder()
                .application(APP_NAME)
                .message(ex.getMessage());
           if (ex instanceof HasCode) {
               messageBuilder.code(((HasCode) ex).getCode());
           }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(messageBuilder.build());
    }

    @ApiResponse(
            responseCode = "500",
            description = "Остальные ошибки",
            content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
    )
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessageDto> exceptionHandler(Exception ex) {
        ErrorMessageDto message = ErrorMessageDto.builder()
                .application(APP_NAME)
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }
}
