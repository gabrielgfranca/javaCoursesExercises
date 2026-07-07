package com.javacourseexercises.abstract1;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new java.util.ArrayList<>();

        IO.print("Enter the number of tax payers: ");
        int taxPayersAmount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= taxPayersAmount; i++) {
            IO.println("Tax Payer #" + i + " data:");

            IO.print("Individual or Company (i/c)? ");
            char payerType = sc.nextLine().toLowerCase().charAt(0);

            IO.print("Name: ");
            String name = sc.nextLine().toUpperCase();

            IO.print("Annual Income: ");
            double annualIncome = sc.nextDouble();
            sc.nextLine();

            if (payerType == 'c') {
                IO.print("Number of Employees: ");
                int numberOfEmployees = sc.nextInt();
                sc.nextLine();
                taxPayerList.add(new Company(name, annualIncome, numberOfEmployees));
            } else if (payerType == 'i') {
                IO.print("Health Expenditures: ");
                double healthExpenditures = sc.nextDouble();
                sc.nextLine();
                taxPayerList.add(new Individual(name, annualIncome, healthExpenditures));
            }
        }

        IO.println();
        IO.println("TAX PAYERS:");
        double totalTax = 0.0;
        for (TaxPayer taxPayer : taxPayerList) {
            totalTax += taxPayer.tax();
            IO.println(taxPayer.getName() + String.format(": $%.2f", taxPayer.tax()));
        }

        IO.println();
        IO.println(String.format("TOTAL TAX: $%.2f", totalTax));

        sc.close();
    }
}

