package com.javacourseexercises.composition.exercise01.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import com.javacourseexercises.composition.exercise01.entities.Department;
import com.javacourseexercises.composition.exercise01.entities.HourContract;
import com.javacourseexercises.composition.exercise01.entities.Worker;
import com.javacourseexercises.composition.exercise01.entities.enums.WorkerLevel;

public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department name: ");
        String deptName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        sc.nextLine();

        Worker worker = new Worker(workerName, workerLevel, baseSalary, new Department(deptName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate ContractDate = LocalDate.parse(sc.next(), fmt);
            
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            
            System.out.print("Duration (Hours): ");
            int hours = sc.nextInt();
            
            HourContract contract = new HourContract(ContractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        
        System.out.println();
        sc.nextLine();
        
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.nextLine();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
