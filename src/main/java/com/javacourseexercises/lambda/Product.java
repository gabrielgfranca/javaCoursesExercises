package com.javacourseexercises.lambda;

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

    public void setPrice(double v) {
        this.price = v;
    }

    public static boolean staticProductPredicate(Product product) {
        // Trabalha com o método do produto passado como parâmetro, não com o objeto atual
        return product.getPrice() >= 100.0;
    }

    public boolean nonStaticProductPredicate() {
        // Trabalha com o método do objeto atual
        return price >= 100.0;
    }

    public static void staticPriceUpdate(Product product) {
        // Trabalha com o método do produto passado como parâmetro, não com o objeto atual
        product.setPrice(product.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate() {
        // Trabalha com o método do objeto atual
        this.price = this.price * 1.1;
    }

    public static String staticUpperCaseName(Product product) {
        // Trabalha com o método do produto passado como parâmetro, não com o objeto atual
        return product.getName().toUpperCase();
    }

    public String nonStaticUpperCaseName() {
        // Trabalha com o método do objeto atual
        return this.name.toUpperCase();
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

}
