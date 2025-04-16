package az.edu.turing.dao;

import az.edu.turing.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightDao {
    Optional<Flight> getById(Long id);
    List<Flight> getAll();
    Optional<Flight> save(Flight flight);
    Optional<Flight> update(Flight flight);
    void delete(Long id);

}
