package com.company;

import java.util.Date;

/**
 * Created by rushmash on 1/15/16.
 */
public class Airline {
    private String from, to;
    private Integer passengers;
    private String number;
    private Airplane plane;
    private Date departureDate, returnDate;

    public Airline() {
    }

    public Airline(String from, String to, Integer passengers, String number, Airplane plane, Date departureDate, Date returnDate) {
        this.from = from;
        this.to = to;
        this.passengers = passengers;
        this.number = number;
        this.plane = plane;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }


    public boolean equalsDate(Airline o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;

        Airline airline = (Airline) o;

        if (!departureDate.equals(airline.departureDate)) return false;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;

        Airline airline = (Airline) o;

        if (!from.equals(airline.from)) return false;
        if (!to.equals(airline.to)) return false;
        if (!passengers.equals(airline.passengers)) return false;
        if (!number.equals(airline.number)) return false;
        if (plane != airline.plane) return false;
        if (!departureDate.equals(airline.departureDate)) return false;
        return returnDate.equals(airline.returnDate);

    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + passengers.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + plane.hashCode();
        result = 31 * result + departureDate.hashCode();
        result = 31 * result + returnDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "from: '" + from + '\'' +
                ", to: '" + to + '\'' +
                ", passengers " + passengers +
                ", number: '" + number + '\'' +
                ", plane: " + plane +
                ", departureDate: " + departureDate +
                ", returnDate: " + returnDate +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Airplane getPlane() {
        return plane;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
