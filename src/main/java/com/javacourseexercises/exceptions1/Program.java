package com.javacourseexercises.exceptions1;

// Solution 1 (very bad): all the validation logic in the main program
// Solution 2 (bad): method returning string
// Solution 3 (good): exception handling

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sc.close();
    }

    private void solutionOne(Scanner sc, SimpleDateFormat sdf) throws ParseException {
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

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                IO.println("Error in reservation: Reservation dates for update must be futures dates");
            } else if (!checkOut.after(checkIn)) {
                IO.println("Error in reservation: Check-out data must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                IO.println("Reservation: " + reservation);
            }
        }
    }

    private void solutionTwo(Scanner sc, SimpleDateFormat sdf) {

    }

    private void solutionThree(Scanner sc, SimpleDateFormat sdf) {

    }
}
