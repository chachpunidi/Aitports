package ru.ch.airport.service.aircraft;

import org.springframework.beans.factory.annotation.Autowired;

import ru.ch.airport.dto.AircraftDto;
import ru.ch.airport.dto.AirportDto;
import ru.ch.airport.service.airport.AirportCrudRepository;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

public class AircraftServiceImpl implements AircraftService {


    private AircraftCrudRepository aircraftCrudRepository;
    @Autowired
    public AircraftServiceImpl(AircraftCrudRepository aircraftCrudRepository) {
        this.aircraftCrudRepository = aircraftCrudRepository;
    }
    @Override
    public List<AircraftDto> findAircrafts() {
        List<AircraftDto> aircraftList = new ArrayList<>();
       Iterable<AircraftDto> aircraftIterable = aircraftCrudRepository.findAll();
       aircraftIterable.forEach(aircraftList::add);
        return aircraftList;
    }


    @Override
    public AircraftDto findAircraft(String code) {
        AircraftDto aircraft = aircraftCrudRepository.findById(code).orElse(null);
        return aircraft;

    }

    @Override
    public Integer createAircraft(AircraftDto aircraft) {
      aircraftCrudRepository.save(aircraft);
      return 1;
    }

    @Override
    public Integer createAircrafts(List<AircraftDto> aircrafts) {
       List<AircraftDto> target = new ArrayList<>();
        Iterable<AircraftDto> returnAircrafts = aircraftCrudRepository.saveAll(aircrafts);
        returnAircrafts.forEach(target::add);
        return target.size();

        }



    @Override
    public Integer updateAircraft(String code, AircraftDto aircraft) {
        aircraft.setCode(code);
        aircraftCrudRepository.save(aircraft);
        return 1;
    }


    @Override
    public Integer deleteAircraft(String code){
      aircraftCrudRepository.deleteById(code);
      return 1;
    }
}