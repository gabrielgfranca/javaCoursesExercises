package com.javacourseexercises.abstract1;

public class Company extends TaxPayer {
    private Integer numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double tax = numberOfEmployees > 10 ? 14 : 16;
        return super.getAnnualIncome() * (tax / 100);
    }
}
