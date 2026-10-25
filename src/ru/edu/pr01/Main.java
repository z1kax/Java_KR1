package ru.edu.pr01;

public class Main {
    public static void main(String[] args) {
        // Тестовые данные: 2 штуки по 1000 руб, скидка 10%, НДС 20%
        int qty = 2;
        double price = 1000.0;
        double disc = 10.0;
        double vat = 20.0;

        System.out.println("Проверка данных: " + OrderCalculator.isValid(qty, price, disc));

        double total = OrderCalculator.calculateTotal(qty, price, disc, vat);
        System.out.println("Итоговая сумма: " + total);
    }
}