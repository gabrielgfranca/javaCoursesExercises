package com.javacourseexercises.lambda.function;

import com.javacourseexercises.lambda.Product;

import java.util.function.Function;

public class UpperCaseName implements Function<Product, String> {
    @Override
    public String apply(Product product) {
        return product.getName().toUpperCase();
    }
}
