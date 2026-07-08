package com.javacourseexercises.exceptions1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void run() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        IO.println("Room Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        IO.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        IO.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            IO.println("Error in reservation: Check-out data must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            IO.println("Reservation: " + reservation);

            IO.println();
            IO.println("Enter data to update the reservation:");

            IO.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            IO.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String errorMessage = reservation.updateDates(checkIn, checkOut);
            if (errorMessage != null) {
                IO.println(errorMessage);
            } else {
                IO.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }
}
