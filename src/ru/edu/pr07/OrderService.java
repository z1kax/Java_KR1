package ru.edu.pr07;

public class OrderService {
    public void validateForConfirm(Order order) {
        if (order.getItems().isEmpty()) throw new IllegalStateException("Пустой заказ");
        order.confirm();
    }
}