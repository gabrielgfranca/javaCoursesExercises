package com.javacourseexercises.lambda.consumer;

import com.javacourseexercises.lambda.Product;

import java.util.function.Consumer;

public class PriceUpdate implements Consumer<Product> {
    @Override
    public void accept(Product product) {
        product.setPrice(product.getPrice() * 1.1);
    }
}
