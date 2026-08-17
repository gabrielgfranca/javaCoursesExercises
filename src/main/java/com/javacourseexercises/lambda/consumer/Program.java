package com.javacourseexercises.lambda.consumer;

import com.javacourseexercises.lambda.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Implementação da Interface
        // list.forEach(new PriceUpdate());

        // Reference method com método estático
        // list.forEach(Product::staticPriceUpdate);

        // Reference method com método não estático
        // list.forEach(Product::nonStaticPriceUpdate);

        // Expressão lambda declarada
        // Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1);
        // list.forEach(cons);

        // Expressão lambda inline
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        list.forEach(System.out::println);
    }
}
