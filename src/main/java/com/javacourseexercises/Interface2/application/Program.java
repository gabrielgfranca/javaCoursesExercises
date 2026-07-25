package com.javacourseexercises.Interface2.application;

import com.javacourseexercises.Interface2.model.entities.Contract;
import com.javacourseexercises.Interface2.model.entities.Installment;
import com.javacourseexercises.Interface2.model.service.ContractService;
import com.javacourseexercises.Interface2.model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        IO.println("Entre os dados do contrato: ");
        IO.println("Número: ");
        int number = sc.nextInt();
        IO.println("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        IO.println("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        IO.println("Entre com o número de parcelas: ");
        int installments = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installments);

        IO.println("Parcelas: ");
        for (Installment installment : contract.getInstallments()) {
            IO.println(installment);
        }

        sc.close();
    }
}
