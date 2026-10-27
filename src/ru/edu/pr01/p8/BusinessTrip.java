package ru.edu.pr01.p8;
import java.time.LocalDate;

public class BusinessTrip {
    private TripStatus status = TripStatus.DRAFT;
    private LocalDate endDate;

    public BusinessTrip(LocalDate endDate) { this.endDate = endDate; }
    public void submit() {
        if (status != TripStatus.DRAFT) throw new IllegalStateException("Только из DRAFT");
        status = TripStatus.SUBMITTED;
    }
    public void approve() {
        if (status != TripStatus.SUBMITTED) throw new IllegalStateException("Только из SUBMITTED");
        status = TripStatus.APPROVED;
    }
    public void reject(String reason) {
        if (status != TripStatus.SUBMITTED) throw new IllegalStateException("Только из SUBMITTED");
        if (reason == null || reason.trim().length() < 10) throw new IllegalArgumentException("Причина от 10 символов");
        status = TripStatus.REJECTED;
    }
    public void cancel() {
        if (status == TripStatus.COMPLETED) throw new IllegalStateException("Нельзя отменить COMPLETED");
        status = TripStatus.CANCELLED;
    }
    public void complete() {
        if (status != TripStatus.APPROVED) throw new IllegalStateException("Только из APPROVED");
        if (LocalDate.now().isBefore(endDate)) throw new IllegalStateException("Командировка не окончена");
        status = TripStatus.COMPLETED;
    }
    public TripStatus getStatus() { return status; }
}