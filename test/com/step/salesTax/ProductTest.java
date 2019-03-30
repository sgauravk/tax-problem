package com.step.salesTax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldReturnTheReceiptDetailsOfUnimportedProducts() {
        Product book = new Product("book",12.49, ProductTypes.BOOKS, Port.UNIMPORTED, 1);
        Product musicCD = new Product("music CD",14.99, ProductTypes.OTHERS, Port.UNIMPORTED, 1);
        Product chocolate = new Product("chocolate bar",0.85, ProductTypes.FOOD, Port.UNIMPORTED, 1);
        Products products = new Products();
        products.addProducts(book).addProducts(musicCD).addProducts(chocolate);

        String expected = "1 book: 12.49\n1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.5\nTotal: 29.83";
        assertEquals(expected, products.getReceipt());
    }

    @Test
    void shouldReturnTheReceiptDetailsOfImportedProducts() {
        Product chocolate = new Product("imported box of chocolates",10.00, ProductTypes.FOOD, Port.IMPORTED, 1);
        Product perfume = new Product("imported bottle of perfume",47.50, ProductTypes.OTHERS, Port.IMPORTED, 1);
        Products products = new Products();
        products.addProducts(chocolate).addProducts(perfume);

        String expected = "1 imported box of chocolates: 10.5\n1 imported bottle of perfume: 54.63\nSales Taxes: 7.63\nTotal: 65.13";
        assertEquals(expected, products.getReceipt());
    }
}