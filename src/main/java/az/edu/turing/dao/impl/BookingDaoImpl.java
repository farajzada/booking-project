package az.edu.turing.dao.impl;

import az.edu.turing.dao.BookingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingDaoImpl implements BookingDao {
    private final Connection connection;

    public BookingDaoImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void createBooking(int flightId, int passengerId) {
        String bookingQuery = "INSERT INTO bookings (flight_id, passenger_id) VALUES (?, ?)";
        String bookingPassengerQuery = "INSERT INTO booking_passenger (booking_id, passenger_id) VALUES (?, ?)";

        try{
            connection.setAutoCommit(false);
            PreparedStatement bookingStatement = connection.prepareStatement(bookingQuery, Statement.RETURN_GENERATED_KEYS);
            bookingStatement.setInt(1, flightId);
            bookingStatement.setInt(2, passengerId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBooking(int bookingId) {

    }

    @Override
    public void updateBooking(int bookingId, int flightId, int passengerId) {

    }

    @Override
    public void getBookingById(int bookingId) {

    }

    @Override
    public void getAllBookings() {

    }
}
