package com.javacourseexercises.polymorphism.exercise02.entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Custom Fee: $ "
                + String.format("%.2f", customsFee)
                + ")";
    }

    public Double totalPrice() {
        return super.getPrice() + customsFee;
    }
}
