package com.javacourseexercises.composition2.application;


import com.javacourseexercises.composition2.model.entities.Client;
import com.javacourseexercises.composition2.model.entities.Order;
import com.javacourseexercises.composition2.model.entities.OrderItem;
import com.javacourseexercises.composition2.model.entities.Product;
import com.javacourseexercises.composition2.model.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        IO.println("Enter client data:");
        IO.print("Name: ");
        String name = sc.nextLine();
        IO.print("Email: ");
        String email = sc.nextLine();
        IO.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Client client = new Client(name, email, birthDate);

        IO.println();

        IO.println("Enter order data:");
        IO.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase().trim());
        Order order = new Order(LocalDateTime.now(), status, client);

        IO.print("How many items to this order? ");
        int items = sc.nextInt();
        sc.nextLine();

        for  (int i=1; i<=items; i++) {
            IO.println("Enter #" + i + " item data:");

            IO.print("Product name: ");
            String productName = sc.nextLine();
            IO.print("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            IO.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(quantity, productPrice, product);

            order.addItem(item);
        }

        IO.println();

        IO.println("ORDER SUMMARY");
        IO.println("Moment: " + order.getMoment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
        IO.println("Status: " + status);
        IO.println(client.toString());
        IO.println("Items: " );
        for (OrderItem item : order.getOrderItems()) {
            IO.println(item.getProduct().getName() + ", $" + item.getPrice() + ", Quantity: " + item.getQuantity() + ", Subtotal: $" + item.subTotal());
        }
        IO.println("Total price: " + order.total());

        sc.close();
    }
}
