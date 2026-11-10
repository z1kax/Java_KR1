package ru.edu.pr07;

public class OrderService {
    // Вариант 8: лимит общей суммы 45
    public static final double MAX_TOTAL_LIMIT = 45.0;

    public void validateForConfirm(Order order) {
        if (order.getItems().isEmpty()) throw new IllegalStateException("Пустой заказ");
        if (order.total() > MAX_TOTAL_LIMIT) throw new IllegalStateException("Сумма больше лимита");
        order.confirm();
    }
}