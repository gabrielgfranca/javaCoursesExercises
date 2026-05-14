package com.javacourseexercises.composition1.entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem() {}

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Product getProduct() {
        return product;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal() {
        return price * quantity;
    }
}
