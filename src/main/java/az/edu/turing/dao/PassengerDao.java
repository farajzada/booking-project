package az.edu.turing.dao;

import az.edu.turing.entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerDao {
    Optional<Passenger> getById(Long id);
    List<Passenger> getAll();
    Optional<Passenger> save(Passenger passenger);
    Optional<Passenger> update(Passenger passenger);
    void delete(Long id);


}
