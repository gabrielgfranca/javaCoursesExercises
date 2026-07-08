package com.javacourseexercises.list1.application;

import com.javacourseexercises.list1.mode.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	
	public void program() {
		
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int numEmployee = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numEmployee; i++) {
            System.out.println();
            System.out.println("Employee #" + i + ":");

            System.out.print("Id: ");
            String id = sc.nextLine();
            while (hasId(employeeList, id)) {
                System.out.println("Id already taken. Try again: ");
				id = sc.nextLine();
            }

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employeeList.add(new Employee(id, name, salary));
        }

        System.out.println();
        System.out.print("Enter the employee ID that wil have salary increase: ");
        String id = sc.nextLine();
        
        Employee obj = employeeList.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        if (obj == null) {
            System.out.println("This id does not exist!");
        } 
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            sc.nextLine();

            obj.increaseSalary(percentage);
        }

        System.out.println();
		System.out.println("List of employees:");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }

        sc.close();
    }

    private boolean hasId(List<Employee> list, String id) {
        Employee obj = list.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        return obj != null;        
    }
}
