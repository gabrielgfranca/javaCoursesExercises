package com.javacourseexercises.polimorfismo2.application;

import com.javacourseexercises.polimorfismo2.model.entities.ImportedProduct;
import com.javacourseexercises.polimorfismo2.model.entities.Product;
import com.javacourseexercises.polimorfismo2.model.entities.UsedProduct;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Program {
    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> productsList = new java.util.ArrayList<>();

        IO.print("Enter the number of products: ");
        int productsAmount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= productsAmount; i++) {
            IO.println("Product #" + i + " data:");

            IO.print("Common, Used or Imported (c/u/i)? ");
            char productType = sc.nextLine().toLowerCase().charAt(0);

            IO.print("Name: ");
            String name = sc.nextLine().toUpperCase();

            IO.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            if (productType == 'c') {
                productsList.add(new Product(name, price));
            } else if (productType == 'i') {
                IO.print("Customs Fee: ");
                double customsFee = sc.nextDouble();
                sc.nextLine();
                productsList.add(new ImportedProduct(name, price, customsFee));
            } else if (productType == 'u') {
                IO.print("Manufacture Date (dd/MM/yyyy): ");
                String manufactureDateStr = sc.nextLine();
                LocalDate manufactureDate = LocalDate.parse(manufactureDateStr, fmt);

                productsList.add(new UsedProduct(name, price, manufactureDate));
            }
        }

        IO.println();
        IO.println("PRODUCTS:");
        for (Product product : productsList) {
            IO.println(product.priceTag());
        }

        sc.close();
    }
}
