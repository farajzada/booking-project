package az.edu.turing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbInitializer {
    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASS"))) {

            Statement stmt = conn.createStatement();

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS flights (
                    id SERIAL PRIMARY KEY,
                    flight_number VARCHAR(50),
                    origin VARCHAR(100),
                    destination VARCHAR(100),
                    departure_time TIMESTAMP,
                    arrival_time TIMESTAMP,
                    total_seats INT,
                    available_seats INT,
                    airplane_model VARCHAR(100),
                    airplane_company VARCHAR(100),
                    created_at TIMESTAMP,
                    updated_at TIMESTAMP
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS passengers (
                    id SERIAL PRIMARY KEY,
                    first_name VARCHAR(100),
                    last_name VARCHAR(100),
                    gender VARCHAR(20),
                    nationality VARCHAR(100),
                    passport VARCHAR(50),
                    created_at TIMESTAMP,
                    updated_at TIMESTAMP
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS bookings (
                    id SERIAL PRIMARY KEY,
                    flight_id BIGINT,
                    price DOUBLE PRECISION,
                    seat_number VARCHAR(20),
                    created_at TIMESTAMP,
                    updated_at TIMESTAMP
                )
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS booking_passengers (
                     booking_id BIGINT NOT NULL,
                     passenger_id BIGINT NOT NULL,
                     PRIMARY KEY (booking_id, passenger_id),
                     FOREIGN KEY (booking_id) REFERENCES bookings(id),
                     FOREIGN KEY (passenger_id) REFERENCES passengers(id)
                 )
            """);

            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
