package com.example.myproject;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExampleSet {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Set<Product> products = new HashSet<>();
            System.out.println("Enter number of products:");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            for (int i = 0; i < n; i++) {
                System.out.println("Enter details of Product " + (i + 1) + ":");
                
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character after nextInt()
                
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                
                System.out.println("Enter price:");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character after nextDouble()
                
                products.add(new Product(id, name, price));
            }
            
            Product HSProduct = findHSProduct(products);
            System.out.println("Highest price product: " + HSProduct);
        }
    }

    private static Product findHSProduct(Set<Product> products) {
        if (products.isEmpty())
            throw new IllegalArgumentException("Set is empty");

        Product HSProduct = null;
        for (Product prd : products) {
            if (HSProduct == null || prd.getprice() > HSProduct.getprice()) {
                HSProduct = prd;
            }
        }
        return HSProduct;
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getid() {
        return id;
    }

    public String getname() {
        return name;
    }

    public double getprice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product { id=" + id + ", name='" + name + "', price=" + price + " }";
    }
}
