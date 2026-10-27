package ru.edu.pr01;

import ru.edu.pr01.p5.TimesheetAnalyzer;
import ru.edu.pr01.p6.*;
import ru.edu.pr01.p7.*;
import ru.edu.pr01.p8.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- ПР5 ---");
        System.out.println(TimesheetAnalyzer.analyze("8;9;10;7;8"));
        System.out.println(TimesheetAnalyzer.analyze("17;8;8;8;8"));

        System.out.println("\n--- ПР6 ---");
        System.out.println("Финансы: " + ApprovalRouter.route(600_000, false, RiskLevel.LOW, false));
        System.out.println("Безопасность: " + ApprovalRouter.route(100, false, RiskLevel.LOW, true));

        System.out.println("\n--- ПР7 ---");
        Order order = new Order();
        Product p1 = new Product("1", "Ноутбук", 50000);
        order.addProduct(p1, 2);
        order.addProduct(p1, 3);
        System.out.println("Итого: " + order.total());

        System.out.println("\n--- ПР8 ---");
        BusinessTrip trip = new BusinessTrip(LocalDate.now().minusDays(1));
        trip.submit();
        trip.approve();
        trip.complete();
        System.out.println("Статус: " + trip.getStatus());
    }
}