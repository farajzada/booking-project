package az.edu.turing.dao;

public interface BookingDao {
    void createBooking(int flightId, int passengerId);

    void deleteBooking(int bookingId);

    void updateBooking(int bookingId, int flightId, int passengerId);

    void getBookingById(int bookingId);

    void getAllBookings();
}
