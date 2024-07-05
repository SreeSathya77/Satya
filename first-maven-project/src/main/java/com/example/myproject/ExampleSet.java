package com.example.myproject;
import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ExampleSet {

    private static final String FILENAME = "products.ser"; // Serialization file name

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Product> products = loadProductsFromFile(); // Load products from file on program start

        if (products.isEmpty()) {
            System.out.println("No products loaded from file.");
        } else {
            System.out.println("Products loaded from file:");
            for (Product product : products) {
                System.out.println(product);
            }
        }

        System.out.println("Enter number of additional products to enter:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character after nextInt()

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of Product " + (products.size() + 1) + ":");

            System.out.println("Enter id:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            System.out.println("Enter name:");
            String name = scanner.nextLine().trim();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character after nextDouble()

            Product newProduct = new Product(id, name, price);
            if (!products.contains(newProduct)) {
                products.add(newProduct);
            } else {
                System.out.println("Product with id " + id + ", name '" + name + "' already exists. Please enter a unique product.");
                i--; // Decrement i to re-enter details for the current product
            }
        }

        saveProductsToFile(products); // Save updated products to file

        if (!products.isEmpty()) {
            Product HSProduct = findHSProduct(products);
            System.out.println("Highest price product: " + HSProduct);
        } else {
            System.out.println("No products entered.");
        }

        scanner.close();
    }

    private static Product findHSProduct(Set<Product> products) {
        Product highestPriceProduct = null;
        for (Product product : products) {
            if (highestPriceProduct == null || product.getPrice() > highestPriceProduct.getPrice()) {
                highestPriceProduct = product;
            }
        }
        return highestPriceProduct;
    }

    private static void saveProductsToFile(Set<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(products);
            System.out.println("Products saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static Set<Product> loadProductsFromFile() {
        Set<Product> products = new HashSet<>();
        File file = new File(FILENAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                products = (Set<Product>) ois.readObject();
                System.out.println("Products loaded from file.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}

class Product implements Serializable {
    private static final long serialVersionUID = 1L; // Manually defined serialVersionUID

    private final int id;
    private final String name;
    private final double price;

    public Product(int id, String name, double price) {
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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return (id == product.id &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name));
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
