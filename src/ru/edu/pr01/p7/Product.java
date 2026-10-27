package ru.edu.pr01.p7;
public class Product {
    private final String id; private final String name; private final double price;
    public Product(String id, String name, double price) {
        if (price <= 0) throw new IllegalArgumentException("Цена > 0");
        this.id = id; this.name = name; this.price = price;
    }
    public String getId() { return id; }
    public double getPrice() { return price; }
}