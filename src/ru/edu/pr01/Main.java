package ru.edu.pr01;

// Импортируем классы из других практик, чтобы Main их видел
import ru.edu.pr03.OrderCalculator;
import ru.edu.pr05.TimesheetAnalyzer;
import ru.edu.pr06.ApprovalRouter;
import ru.edu.pr06.RiskLevel;
import ru.edu.pr07.Order;
import ru.edu.pr07.Product;
import ru.edu.pr08.BusinessTrip;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- ПР1/ПР3 Калькулятор ---");
        System.out.println("Проверка: " + OrderCalculator.isValid(2, 1000.0, 10.0));
        System.out.println("Итог: " + OrderCalculator.calculateTotal(2, 1000.0, 10.0, 20.0));

        System.out.println("\n--- ПР5 Табель ---");
        System.out.println(TimesheetAnalyzer.analyze("8;9;10;7;8"));
        System.out.println(TimesheetAnalyzer.analyze("17;8;8;8;8"));

        System.out.println("\n--- ПР6 Маршруты ---");
        System.out.println("Финансы: " + ApprovalRouter.route(600_000, false, RiskLevel.LOW, false));
        System.out.println("Безопасность: " + ApprovalRouter.route(100, false, RiskLevel.LOW, true));

        System.out.println("\n--- ПР7 Заказ ---");
        Order order = new Order();
        Product p1 = new Product("1", "Ноутбук", 50000);
        order.addProduct(p1, 2);
        order.addProduct(p1, 3);
        System.out.println("Итого: " + order.total());

        System.out.println("\n--- ПР8 Командировка ---");
        BusinessTrip trip = new BusinessTrip(LocalDate.now().minusDays(1));
        trip.submit();
        trip.approve();
        trip.complete();
        System.out.println("Статус: " + trip.getStatus());
    }
}