package com.step.salesTax;

import java.util.ArrayList;
import java.util.List;

class Products {
    private List<Product> productsList;

    Products() {
        this.productsList = new ArrayList<>();
    }

    Products addProducts(Product product) {
        this.productsList.add(product);
        return this;
    }

    private String addFooter() {
        double salesTax = this.calculateTotalSalesTax();
        double total = this.calculateTotalPrice();
        return "Sales Taxes: " + salesTax + "\nTotal: " + total;
    }

    private double calculateTotalPrice() {
        double price = productsList.stream().mapToDouble(Product::calculateFinalPrice).sum();
        return Math.round(price * 100.0) / 100.0;
    }

    private double calculateTotalSalesTax() {
        double tax = productsList.stream().mapToDouble(Product::calculateTotalTax).sum();
        return Math.round(tax * 100.0) / 100.0;
    }

    String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (Product product : this.productsList) {
            receipt.append(product.getQuantity()).append(" ").append(product.getProductName());
            receipt.append(": ").append(product.calculateFinalPrice()).append("\n");
        }
        receipt.append(addFooter());
        return receipt.toString();
    }
}
