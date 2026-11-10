package ru.edu.pr08;

import java.time.LocalDate;

public class BusinessTrip {
    private TripStatus status = TripStatus.DRAFT;
    private LocalDate endDate;
    // Вариант 8: правило отмены 45 дней
    public static final int CANCEL_DAYS_LIMIT = 45;

    public BusinessTrip(LocalDate endDate) { this.endDate = endDate; }

    public void submit() {
        if (status != TripStatus.DRAFT) throw new IllegalStateException("Только из DRAFT");
        status = TripStatus.SUBMITTED;
    }
    public void approve() {
        if (status != TripStatus.SUBMITTED) throw new IllegalStateException("Только из SUBMITTED");
        status = TripStatus.APPROVED;
    }
    public void cancel() {
        if (status == TripStatus.COMPLETED) throw new IllegalStateException("Нельзя отменить COMPLETED");
        if (LocalDate.now().plusDays(CANCEL_DAYS_LIMIT).isAfter(endDate)) {
            throw new IllegalStateException("До конца командировки меньше 45 дней");
        }
        status = TripStatus.CANCELLED;
    }
    public void complete() {
        if (status != TripStatus.APPROVED) throw new IllegalStateException("Только из APPROVED");
        if (LocalDate.now().isBefore(endDate)) throw new IllegalStateException("Еще не окончена");
        status = TripStatus.COMPLETED;
    }
    public TripStatus getStatus() { return status; }
}