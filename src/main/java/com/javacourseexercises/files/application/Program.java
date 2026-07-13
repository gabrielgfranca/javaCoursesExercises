package com.javacourseexercises.files.application;

import com.javacourseexercises.files.entities.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> productsList = new java.util.ArrayList<>();

        // src/main/java/com/javacourseexercises/files/sourceFile.csv
        IO.print("Enter file path: ");
        String SourceFileStr = sc.nextLine();

        File sourceFile = new File(SourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "/out").mkdir();

        String targetFileStr = sourceFolderStr + "/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(SourceFileStr))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);
                Product product = new Product(name, price, quantity);
                productsList.add(product);
                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                for (Product item : productsList) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.totalPrice()));
                    bw.newLine();
                }

                IO.println(targetFileStr + " CREATED!");
            } catch (IOException e) {
                IO.println("Error writing file: " + e.getMessage());
            }
        } catch (IOException e) {
            IO.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
