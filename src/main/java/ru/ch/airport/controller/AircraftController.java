package ru.ch.airport.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ch.airport.dto.AircraftDto;
import ru.ch.airport.service.aircraft.AircraftService;

import java.util.List;

@RestController
@RequestMapping("/aircrafts")
@Tag(name = "Контроллер для работы с самолетами")
public class AircraftController {

    private AircraftService aircraftService;


    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }


    @Operation(description = "Получить список самолетов", summary = "Получить список самолетов")
    @GetMapping
    public List<AircraftDto> aircrafts() {
        return aircraftService.findAircrafts();
    }

    @Operation(description = "Получить самолет по коду", summary = "Получить самолет по коду")
    @GetMapping("/{code}")
    public AircraftDto aircraft(
            @Parameter(description = "Код самолета", example = "123")
            @PathVariable(value = "code")
            String code
    ) {
        return aircraftService.findAircraft(code);
    }


    @Operation(description = "Создание самолета", summary = "Создание самолета")
    @PutMapping
    public Integer createAircraft(@RequestBody AircraftDto aircraft) {
      return   aircraftService.createAircraft(aircraft);
    }


    @Operation(description = "Создание списка самолетов", summary = "Создание списка самолетов")
    @PutMapping("batch")
    public Integer createAircrafts(@RequestBody List<AircraftDto> aircrafts) {
        Integer x = aircraftService.createAircrafts(aircrafts);
        return x;
    }

    @Operation(description = "Обновить самолет по коду", summary = "Обновить самолет по коду")
    @PatchMapping("/{code}")
    public Integer updateAircraft(
            @Parameter(description = "Код самолета", example = "t34")
            @PathVariable(value = "code") String code,
            @RequestBody AircraftDto aircraft
    ) {
        return aircraftService.updateAircraft(code, aircraft);
    }


    @Operation(description = "Удалить самолет по коду", summary = "Удалить  самолет по коду")
    @DeleteMapping("/{code}")
    public Integer deleteAircraft(
            @Parameter(description = "Код самолета", example = "t33")
            @PathVariable(value = "code")
            String code
    ) {
        return aircraftService.deleteAircraft(code);
    }
}



