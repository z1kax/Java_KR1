package ru.edu.pr07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.DRAFT; // Используем Enum

    public void addProduct(Product product, int quantity) {
        if (status != OrderStatus.DRAFT) {
            throw new IllegalStateException("Нельзя менять заказ в статусе " + status);
        }
        for (OrderItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new OrderItem(product, quantity));
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void confirm() {
        if (items.isEmpty()) throw new IllegalStateException("Заказ пуст");
        if (status != OrderStatus.DRAFT) throw new IllegalStateException("Уже подтвержден");
        status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (status == OrderStatus.CONFIRMED) throw new IllegalStateException("Нельзя отменить");
        status = OrderStatus.CANCELLED;
    }

    public double total() {
        double sum = 0;
        for (OrderItem item : items) sum += item.getProduct().getPrice() * item.getQuantity();
        return sum;
    }

    public OrderStatus getStatus() { return status; }
}