package az.edu.turing.dao;

public interface FlightDao {
    void createFlight(int flightId, String flightNumber, String departure, String arrival, String date, String time);

    void deleteFlight(int flightId);

    void updateFlight(int flightId, String flightNumber, String departure, String arrival, String date, String time);

    void getFlightById(int flightId);

    void getAllFlights();

}
