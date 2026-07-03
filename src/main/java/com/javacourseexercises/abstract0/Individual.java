package com.javacourseexercises.abstract0;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double tax = super.getAnnualIncome() < 20000.00 ? 15 : 25;
        return (getAnnualIncome() * (tax / 100)) - (healthExpenditures * 0.5);
    }

}
