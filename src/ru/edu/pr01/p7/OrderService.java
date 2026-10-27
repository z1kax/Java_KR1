package ru.edu.pr01.p7;
public class OrderService {
    public void validateForConfirm(Order order) {
        if (order.getItems().isEmpty()) throw new IllegalStateException("Пустой заказ");
        order.confirm();
    }
}