package com.javacourseexercises.Interface1.application;

import com.javacourseexercises.Interface1.model.entities.CarRental;
import com.javacourseexercises.Interface1.model.entities.Vehicle;
import com.javacourseexercises.Interface1.model.services.BrazilTaxService;
import com.javacourseexercises.Interface1.model.services.RentalServices;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        IO.println("Entre com os dados do aluguel");
        IO.print("Modelo do Carro: ");
        String carModel = sc.nextLine();
        IO.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        IO.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        IO.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        IO.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalServices rentalServices = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalServices.processInvoice(carRental);

        IO.println();
        IO.println("FATURA: ");
        IO.println("Pagamento básico: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        IO.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
        IO.println("Pagamento total: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
    }
}
