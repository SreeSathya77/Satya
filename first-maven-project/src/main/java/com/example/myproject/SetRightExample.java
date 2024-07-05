package com.example.myproject;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class SetRightExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<SProduct> products = new HashSet<>();

        System.out.println("Enter number of products:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of Product " + (i + 1) + ":");

            System.out.println("Enter id:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            System.out.println("Enter name:");
            String name = scanner.nextLine().trim();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character after nextDouble()

            SProduct newProduct = new SProduct(id, name, price);
            if (!products.contains(newProduct)) {
                products.add(newProduct);
            } else {
                System.out.println("Product with id " + id + ", name '" + name + "' already exists. Please enter a unique product.");
                i--; // Decrement i to re-enter details for the current product
            }
        }

        if (!products.isEmpty()) {
            SProduct HSProduct = findHSProduct(products);
            System.out.println("Highest price product: " + HSProduct);
        } else {
            System.out.println("No products entered.");
        }

        scanner.close();
    }

    private static SProduct findHSProduct(Set<SProduct> products) {
        SProduct highestPriceProduct = null;
        for (SProduct product : products) {
            if (highestPriceProduct == null || product.getPrice() > highestPriceProduct.getPrice()) {
                highestPriceProduct = product;
            }
        }
        return highestPriceProduct;
    }
}

class SProduct {
    private final int id;
    private final String name;
    private final double price;

    public SProduct(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SProduct)) return false;
        SProduct product = (SProduct) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product { id=" + id + ", name='" + name + "', price=" + price + " }";
    }
}
