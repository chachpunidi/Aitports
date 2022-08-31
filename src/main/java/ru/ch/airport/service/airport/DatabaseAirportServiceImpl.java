package ru.ch.airport.service.airport;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ch.airport.dto.AirportDto;

import java.util.List;

public class DatabaseAirportServiceImpl implements AirportService {

    private AirportMapper airportMapper;


    @Autowired
    public DatabaseAirportServiceImpl(AirportMapper airportMapper) {
        this.airportMapper = airportMapper;
    }
    @Override
    public List<AirportDto> findAirports() {

        return airportMapper.findAll();
    }

    @Override
    public AirportDto findAirport(String code) {

        return airportMapper.findByCode(code);
    }

    @Override
    public Integer createAirport(AirportDto airport) {
        Integer x = airportMapper.save(airport);
        return x;
    }

    @Override
    public Integer createAirports(List<AirportDto> airports) {
        int rec = 0;
        for(AirportDto airport: airports) {
            AirportDto foudeAirport = findAirport(airport.getCode());
            if (foudeAirport != null) {
                throw new RuntimeException();
            }
            Integer operationCount = airportMapper.save(airport);
            rec = rec + operationCount;

        }
        return  rec;
    }

    @Override
    public Integer deleteAirport(String code) {
       Integer x = airportMapper.delete(code);
        return x;
    }

    @Override
    public Integer updateAirport(String code, AirportDto airport) {
       Integer x =  airportMapper.update(code, airport);
        return x;
    }
}

