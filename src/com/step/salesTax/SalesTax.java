package com.step.salesTax;

public class SalesTax implements TaxCalculator {

    @Override
    public double calculateTax(double basePrice) {
        return basePrice / 10;
    }
}
