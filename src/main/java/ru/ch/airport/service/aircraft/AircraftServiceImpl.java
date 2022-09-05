package ru.ch.airport.service.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ch.airport.dto.AircraftDto;

import java.util.List;

public class AircraftServiceImpl implements AircraftService {


    private AircraftMapper aircraftMapper;
    @Autowired
    public AircraftServiceImpl(AircraftMapper aircraftMapper) {
        this.aircraftMapper = aircraftMapper;
    }

    @Override
    public List<AircraftDto> findAircrafts() {

        return aircraftMapper.findAll();
    }

    @Override
    public AircraftDto findAircraft(String code) {
        return aircraftMapper.findByCode(code);

    }

    @Override
    public Integer createAircraft(AircraftDto aircraft) {
        Integer x =   aircraftMapper.save(aircraft);
        return x;
    }

    @Override
    public Integer createAircrafts(List<AircraftDto> aircrafts) {
       Integer x = aircraftMapper.saveAll(aircrafts);
       return x;
    }

    @Override
    public Integer updateAircraft(String code, AircraftDto aircraft) {
        Integer x =  aircraftMapper.update(code, aircraft);
        return x;
    }

    @Override
    public Integer deleteAircraft(String code){
        Integer x = aircraftMapper. delete(code);
        return x;
    }
}