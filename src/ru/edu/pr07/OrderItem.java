package ru.edu.pr07;

public class OrderItem {
    private final Product product; private int quantity;
    public OrderItem(Product product, int quantity) {
        this.product = product; setQuantity(quantity);
    }
    public void setQuantity(int quantity) {
        if (quantity < 1 || quantity > 100) throw new IllegalArgumentException("Кол-во от 1 до 100");
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}