package ru.edu.pr01.p5;

public class TimesheetAnalyzer {
    public static String analyze(String line) {
        if (line == null || line.isEmpty()) return "Ошибка: пустая строка";
        String[] parts = line.split(";");
        if (parts.length != 5) return "Ошибка: нужно ровно 5 значений";

        int[] hours = new int[5];
        for (int i = 0; i < parts.length; i++) {
            try {
                hours[i] = Integer.parseInt(parts[i].trim());
                if (hours[i] < 0 || hours[i] > 16) return "Ошибка: позиция " + (i + 1) + " вне диапазона [0;16]";
            } catch (NumberFormatException e) {
                return "Ошибка: позиция " + (i + 1) + " не является числом";
            }
        }
        int sum = 0; int otDays = 0;
        for (int h : hours) {
            sum += h;
            if (h > 8) otDays++;
        }
        double avg = (double) sum / 5;
        int otWeek = Math.max(0, sum - 40);
        return String.format("Сумма: %d, среднее: %.2f, дней с переработкой: %d, переработка за неделю: %d", sum, avg, otDays, otWeek);
    }
}