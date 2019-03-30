package com.step.salesTax;

class Product {
    private String productName;
    private ProductTypes productType;
    private double basePrice;
    private Port portType;
    private int quantity;

    Product(String productName, double basePrice, ProductTypes productType, Port portType, int quantity) {
        this.productName = productName;
        this.basePrice = basePrice;
        this.productType = productType;
        this.portType = portType;
        this.quantity = quantity;
    }

    private double calculateImportedTax() {
        TaxCalculator calculator = new ImportTax();
        if (this.portType != Port.IMPORTED) return 0;
        return calculator.calculateTax(this.basePrice);
    }

    private double calculateSalesTax() {
        TaxCalculator calculator = new SalesTax();
        if (this.productType != ProductTypes.OTHERS) return 0;
        return calculator.calculateTax(this.basePrice);
    }

    // todo :- logic to calculate tax should not be in product.

    double calculateTotalTax() {
        double importedTex = this.calculateImportedTax();
        double salesTax = this.calculateSalesTax();
        return importedTex + salesTax;
    }

    String getProductName() {
        return this.productName;
    }

    double calculateFinalPrice() {
        double finalPrice = this.calculateTotalTax() + this.basePrice;
        return Math.round(finalPrice * 100.0) / 100.0;
    }

    int getQuantity() {
        return quantity;
    }
}
