package com.javacourseexercises.composition;

import java.util.Locale;
import java.util.Scanner;

import com.javacourseexercises.composition.entities.Department;
import com.javacourseexercises.composition.entities.Worker;
import com.javacourseexercises.composition.entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter department name: ");
        String deptName = sc.nextLine();
        Department department = new Department(deptName);

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        sc.nextLine();
        Worker worker = new Worker(workerName, workerLevel, baseSalary, department);

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();
        String date;
        Double valuePerHour = 0.0;
        int hours = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract #" + i + " data:");
            
            System.out.print("Date (DD/MM/YYYY): ");
            date = sc.nextLine();
            
            System.out.print("Value per hour: ");
            valuePerHour += sc.nextDouble();
            
            System.out.print("Duration (Hours): ");
            hours += sc.nextInt();
            sc.nextLine(); 
        }

        sc.close();
    }
}
