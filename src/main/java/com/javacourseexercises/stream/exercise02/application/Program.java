package com.javacourseexercises.stream.exercise02.application;

import com.javacourseexercises.stream.exercise01.entities.Product;
import com.javacourseexercises.stream.exercise02.entities.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // src/main/java/com/javacourseexercises/stream/exercise02/input.txt
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        double compSalary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            List<Employee> list = new java.util.ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                String email = fields[1];
                double salary = Double.parseDouble(fields[2]);

                list.add(new Employee(name, email, salary));
                line = br.readLine();
            }

            System.out.println("Email of people with salary greater than " + compSalary);
            List<String> emails = list.stream()
                    .filter(p -> p.getSalary() > compSalary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();
            emails.forEach(System.out::println);

            System.out.println("Sum of salary of people whose name starts with 'M': " +
                    list.stream()
                            .filter(p -> p.getName().toUpperCase().charAt(0) == 'M')
                            .map(Employee::getSalary)
                            .reduce(0.0, Double::sum));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
