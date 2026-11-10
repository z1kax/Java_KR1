package ru.edu.pr05;

public class TimesheetAnalyzer {
    // Вариант 8: верхняя граница 45
    public static final int MAX_HOURS_PER_DAY = 45;
    public static final int DAYS_IN_WEEK = 5;

    public static String analyze(String line) {
        if (line == null || line.isEmpty()) return "Ошибка: пустая строка";
        String[] parts = line.split(";");
        if (parts.length != DAYS_IN_WEEK) return "Ошибка: нужно ровно 5 значений";

        int[] hours = new int[5];
        for (int i = 0; i < parts.length; i++) {
            try {
                hours[i] = Integer.parseInt(parts[i].trim());
                if (hours[i] < 0 || hours[i] > MAX_HOURS_PER_DAY)
                    return "Ошибка: позиция " + (i + 1) + " вне диапазона";
            } catch (NumberFormatException e) {
                return "Ошибка: позиция " + (i + 1) + " не число";
            }
        }
        int sum = 0; int otDays = 0;
        for (int h : hours) {
            sum += h;
            if (h > 8) otDays++;
        }
        double avg = (double) sum / DAYS_IN_WEEK;
        int otWeek = Math.max(0, sum - 40);
        return String.format("Сумма: %d, среднее: %.2f, дней с переработкой: %d, переработка за неделю: %d", sum, avg, otDays, otWeek);
    }
}