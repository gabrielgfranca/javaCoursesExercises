package com.javacourseexercises.lambda.predicate;

import com.javacourseexercises.lambda.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // Implementação da Interface
        // list.removeIf(new ProductPredicate());

        // Reference method com método estático
        // list.removeIf(Product::staticProductPredicate);

        // Reference method com método não estático
        // list.removeIf(Product::nonStaticProductPredicate);

        // Expressão lambda declarada
        // Predicate<Product> predicate = p -> p.getPrice() < 100.00;
        // list.removeIf(predicate);

        // Expressão lambda inline
        list.removeIf(p -> p.getPrice() < 100.00);


        list.forEach(System.out::println);
    }
}
