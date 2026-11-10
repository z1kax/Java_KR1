package ru.edu.pr06;

public class ApprovalRouter {
    public static final long FINANCE_LIMIT = 500_000;
    // Вариант 8: приоритет риска 50
    public static final int RISK_PRIORITY = 50;

    public static ApprovalRoute route(long sum, boolean urgent, RiskLevel risk, boolean containsPersonalData) {
        if (containsPersonalData) return ApprovalRoute.SECURITY_REVIEW;
        if (risk == RiskLevel.HIGH) return ApprovalRoute.DIRECTOR_REVIEW;
        if (sum >= FINANCE_LIMIT) return ApprovalRoute.FINANCE_REVIEW;
        if (urgent) return ApprovalRoute.FAST_TRACK;
        return ApprovalRoute.STANDARD;
    }
}