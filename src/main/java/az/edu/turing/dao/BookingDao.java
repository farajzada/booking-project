package az.edu.turing.dao;

import az.edu.turing.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingDao{
    Optional<Booking> getById(Long id);
    List<Booking> getAll();
    Optional<Booking> save(Booking booking,List<Long> passengerIds);
    Optional<Booking> update(Booking booking);
    void delete(Long id);

}
