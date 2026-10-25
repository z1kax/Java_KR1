package ru.edu.pr01;

public class OrderCalculator {

    // TODO 1: Проверка корректности данных (количество, цена, скидка)
    public static boolean isValid(int quantity, double unitPrice, double discountPercent) {
        // Количество должно быть больше 0 и не больше 10 000
        // Цена должна быть больше 0 и не больше 5 000 000
        // Скидка должна быть от 0 до 30
        return false; // Пока возвращаем false, потом исправим
    }

    // TODO 2: Вычислить базовую сумму (количество * цена)
    public static double calculateBase(int quantity, double unitPrice) {
        return 0.0; // Пока 0, потом исправим
    }

    // TODO 3: Применить скидку (база - (база * скидка / 100))
    public static double applyDiscount(double base, double discountPercent) {
        return base; // Пока без изменений, потом исправим
    }

    // TODO 4: Вычислить НДС (сумма_со_скидкой * ставка_НДС / 100)
    public static double calculateVat(double discounted, double vatPercent) {
        return 0.0; // Пока 0, потом исправим
    }

    // TODO 5: Итоговая сумма (сумма_со_скидкой + НДС)
    public static double calculateTotal(int quantity, double unitPrice, double discountPercent, double vatPercent) {
        return 0.0; // Пока 0, потом исправим
    }
}