package ru.edu.pr07;

import java.util.ArrayList; import java.util.Collections; import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();
    private boolean confirmed = false;

    public void addProduct(Product product, int quantity) {
        if (confirmed) throw new IllegalStateException("Заказ подтвержден");
        for (OrderItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new OrderItem(product, quantity));
    }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }
    public void confirm() { this.confirmed = true; }
    public double total() {
        double sum = 0;
        for (OrderItem item : items) sum += item.getProduct().getPrice() * item.getQuantity();
        return sum;
    }
}