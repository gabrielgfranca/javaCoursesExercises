package com.javacourseexercises.exceptions2.application;

import com.javacourseexercises.exceptions2.model.entities.Account;
import com.javacourseexercises.exceptions2.model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        IO.println("Enter account data");
        IO.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        IO.print("Holder: ");
        String holder = sc.nextLine().toUpperCase();
        IO.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        IO.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        IO.println();
        IO.print("Enter the amount for withdraw: ");
        double withdrawAmount = sc.nextDouble();

        try {
            account.withdraw(withdrawAmount);
            IO.println("New balance: " + String.format("%.2f", account.getBalance()));
        } catch (BusinessException e) {
            IO.println(e.getMessage());
        } catch (RuntimeException e) {
            IO.println("Unexpected error");
        }

        sc.close();
    }
}
