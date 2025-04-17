package az.edu.turing.dao.impl;

import az.edu.turing.dao.BookingDao;
import az.edu.turing.entity.Booking;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class BookingDaoImpl implements BookingDao {

    private static final String INSERT_BOOKING_SQL =
            "INSERT INTO bookings (flight_id, price, seat_number, created_at, updated_at) VALUES (?, ?, ?, ?, ?) RETURNING id";
    private static final String INSERT_BOOKING_PASSENGER_SQL =
            "INSERT INTO booking_passenger (booking_id, passenger_id) VALUES (?, ?)";
    private static final String SELECT_BOOKING_BY_ID_SQL =
            "SELECT * FROM bookings WHERE id = ?";
    private static final String SELECT_ALL_BOOKINGS_SQL =
            "SELECT * FROM bookings";
    private static final String DELETE_BOOKING_PASSENGER_SQL =
            "DELETE FROM booking_passenger WHERE booking_id = ?";
    private static final String DELETE_BOOKING_SQL =
            "DELETE FROM bookings WHERE id = ?";

    private final Connection connection;

    public BookingDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Booking> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Booking> getAll() {
        return List.of();
    }

    @Override
    public Optional<Booking> save(Booking booking, List<Long> passengerIds) {
        try {
            try (PreparedStatement stmt = connection.prepareStatement(INSERT_BOOKING_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setLong(1, booking.getFlightId());
                stmt.setDouble(2, booking.getPrice());
                stmt.setString(3, booking.getSeatNumber());

                int affectedRows = stmt.executeUpdate();

                if (affectedRows == 0) {
                    return Optional.empty();
                }

                try (var generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long bookingId = generatedKeys.getLong(1);

                        try (PreparedStatement passengerStmt = connection.prepareStatement(INSERT_BOOKING_PASSENGER_SQL)) {
                            for (Long passengerId : passengerIds) {
                                passengerStmt.setLong(1, bookingId);
                                passengerStmt.setLong(2, passengerId);
                                passengerStmt.addBatch();
                            }

                            passengerStmt.executeBatch();
                        }

                        booking.setId(bookingId);
                        return Optional.of(booking);
                    } else {
                        return Optional.empty();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Booking> update(Booking booking) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
