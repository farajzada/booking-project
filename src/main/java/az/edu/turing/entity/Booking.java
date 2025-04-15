package az.edu.turing.entity;


public class Booking extends BaseEntity {
    private Long flightId;
    private double price;
    private String seatNumber;

    public Booking(Long flightId, double price, String seatNumber) {
        this.flightId = flightId;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
