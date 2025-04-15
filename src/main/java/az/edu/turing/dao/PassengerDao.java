package az.edu.turing.dao;

import az.edu.turing.entity.Passenger;

import java.util.List;

public interface PassengerDao {
    void insertPassenger(Passenger passenger);
    void updatePassenger(Passenger passenger);
    void deletePassenger(int passengerId);
    Passenger getPassengerById(int passengerId);
    List<Passenger> getAllPassengers();

}
