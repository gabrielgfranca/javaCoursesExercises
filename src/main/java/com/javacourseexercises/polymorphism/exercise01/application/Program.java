package com.javacourseexercises.polymorphism.exercise01.application;

import com.javacourseexercises.polymorphism.exercise01.entities.Employee;
import com.javacourseexercises.polymorphism.exercise01.entities.OutsourcedEmployee;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeesList = new java.util.ArrayList<>();

        IO.print("Enter the number of employees: ");
        int employees = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= employees; i++) {
            IO.println("Employee #" + i + " data:");

            IO.print("Outsource employee (y/n)? ");
            char outsourced = sc.nextLine().toLowerCase().charAt(0);

            IO.print("Name: ");
            String name = sc.nextLine().toUpperCase();

            IO.print("Hours: ");
            int hours = sc.nextInt();
            sc.nextLine();

            IO.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            sc.nextLine();

            if (outsourced == 'y') {
                IO.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                sc.nextLine();
                employeesList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employeesList.add(new Employee(name, hours, valuePerHour));
            }
        }

        IO.println();
        IO.println("PAYMENTS:");
        for (Employee emp : employeesList) {
            IO.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }
}
