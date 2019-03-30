package com.step.salesTax;

public class ImportTax implements TaxCalculator {

    @Override
    public double calculateTax(double basePrice) {
        return basePrice / 20;
    }
}
