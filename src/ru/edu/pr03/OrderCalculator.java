package ru.edu.pr03;

public class OrderCalculator {

    public static boolean isValid(int quantity, double unitPrice, double discountPercent) {
        // Проверяем, что количество от 1 до 10000
        if (quantity <= 0 || quantity > 10000) {
            return false;
        }
        // Проверяем, что цена положительная и не больше 5 млн
        if (unitPrice <= 0 || unitPrice > 5000000) {
            return false;
        }
        // Проверяем, что скидка от 0 до 30
        if (discountPercent < 0 || discountPercent > 30) {
            return false;
        }
        // Если все проверки пройдены — данные верны
        return true;
    }

    public static double calculateBase(int quantity, double unitPrice) {
        return quantity * unitPrice;
    }

    public static double applyDiscount(double base, double discountPercent) {
        double discountAmount = base * (discountPercent / 100);
        return base - discountAmount;
    }

    public static double calculateVat(double discounted, double vatPercent) {
        return discounted * (vatPercent / 100);
    }

    public static double calculateTotal(int quantity, double unitPrice, double discountPercent, double vatPercent) {
        double base = calculateBase(quantity, unitPrice);
        double discounted = applyDiscount(base, discountPercent);
        double vat = calculateVat(discounted, vatPercent);

        return discounted + vat;
    }
}