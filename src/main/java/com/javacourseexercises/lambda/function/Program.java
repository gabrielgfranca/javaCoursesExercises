package com.javacourseexercises.lambda.function;

import com.javacourseexercises.lambda.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Implementação da Interface
        // List<String> names = list.stream().map(new UpperCaseName()).toList();

        // Reference method com método estático
        // List<String> names = list.stream().map(Product::staticUpperCaseName).toList();

        // Reference method com método não estático
        // List<String> names = list.stream().map(Product::nonStaticUpperCaseName).toList();

        // Expressão lambda declarada
        // Function<Product, String> func = p -> p.getName().toUpperCase();
        // List<String> names = list.stream().map(func).toList();

        // Expressão lambda inline
        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).toList();

        names.forEach(System.out::println);
    }
}
