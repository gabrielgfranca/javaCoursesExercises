package com.javacourseexercises.exceptions1;

import java.time.LocalDate;

public class Reservation {
    private Integer roonNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {
    }

    public Reservation(Integer roonNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roonNumber = roonNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoonNumber() {
        return roonNumber;
    }

    public void setRoonNumber(Integer roonNumber) {
        this.roonNumber = roonNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer duration() {
        return 0;
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
