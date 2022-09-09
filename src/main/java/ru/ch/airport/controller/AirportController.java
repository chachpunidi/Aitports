package ru.ch.airport.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ch.airport.dto.AirportDto;
import ru.ch.airport.exception.CodeNotExistException;
import ru.ch.airport.service.airport.AirportService;

import java.util.List;

@RestController
@RequestMapping("/airports")
@Tag(name = "Контроллер для работы с аэропортами")
public class AirportController {

    private AirportService airportService;


    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }


    @Operation(description = "Получить список аэропортов", summary = "Получить список аэропортов")
    @GetMapping
    public List<AirportDto> airports() {

        return airportService.findAirports();
    }

    @Operation(description = "Получить аэропорт по коду", summary = "Получить аэропорт по коду")
    @GetMapping("/{code}")
    public AirportDto airport(
            @Parameter(description = "Код аэропорта", example = "NBC")
            @PathVariable(value = "code")
            String code
    ) {
        return airportService.findAirport(code);
    }


    @Operation(description = "Создание аэропорта", summary = "Создание аэропорта")
    @PutMapping
    public Integer createAirport(@RequestBody AirportDto airport) {
        return airportService.createAirport(airport);
    }


    @Operation(description = "Создание списка аэропортов", summary = "Создание списка аэропортов")
    @PostMapping("/batch")
    public Integer createAirports(@RequestBody List<AirportDto> airports) {
        return airportService.createAirports(airports);
    }

    @Operation(description = "Удалить  аэропорт по коду", summary = "Удалить  аэропорт по коду")
    @DeleteMapping("/{code}")
    public Integer deleteAirport(
            @Parameter(description = "Код аэропорта", example = "111")
            @PathVariable(value = "code")
            String code)  {
       return airportService.deleteAirport(code);

    }

    @Operation(description = "Обновить аэропорт по коду", summary = "Обновить аэропорт по коду")
    @PatchMapping("/{code}")
    public Integer updateAirport(
            @Parameter(description = "Код аэропорта", example = "116")
            @PathVariable(value = "code") String code,
            @RequestBody AirportDto airport) {
        return airportService.updateAirport(code, airport);
    }

}