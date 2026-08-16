package com.javacourseexercises.lambda.predicate;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static boolean staticProductPredicate(Product product) {
        // Trabalha com o método do produto passado como parâmetro, não com o objeto atual
        return product.getPrice() >= 100.0;
    }

    public boolean nonStaticProductPredicate() {
        // Trabalha com o método do objeto atual
        return price >= 100.0;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }
}
