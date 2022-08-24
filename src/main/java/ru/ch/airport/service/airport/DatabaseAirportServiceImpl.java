package ru.ch.airport.service.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.ch.airport.SqlConsumer;
import ru.ch.airport.dto.AirportDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatabaseAirportServiceImpl implements AirportService {

    private AirportCrudRepository airportCrudRepository;


    @Autowired
    public DatabaseAirportServiceImpl(AirportCrudRepository airportCrudRepository) {
        this.airportCrudRepository = airportCrudRepository;
    }
    @Override
    public List<AirportDto> findAirports() {
        List<AirportDto> target = new ArrayList<>();
        Iterable<AirportDto> airportIterable = airportCrudRepository.findAll();
        airportIterable.forEach(target::add);
        return target;
    }
    @Override
    public AirportDto findAirport(String code) {
        AirportDto airport = airportCrudRepository.findById(code).orElse(null);
        return airport;
    }

    @Override
    public Integer createAirport(AirportDto airport) {
        airportCrudRepository.save(airport);
        return 1;

    }

    @Override
    @Transactional
    public Integer createAirports(List<AirportDto> airports) {
        int rec = 0;
        for (AirportDto airport: airports) {
            AirportDto foudedAirport = findAirport(airport.getCode());
            if (foudedAirport != null) {
                throw new RuntimeException("Добавляемый аэропорт уже существует");
            }
            airportCrudRepository.save(airport);
            rec = rec + 1;
        };
        return  rec;
    }

    @Override
    public Integer deleteAirport(String code) {
        airportCrudRepository.deleteById(code);
        return 1;
    }

    @Override

    public Integer updateAirport(String code, AirportDto airport) {
        airport.setCode(code);
        airportCrudRepository.save(airport);
        return 1;

    }
}

