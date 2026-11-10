package ru.edu.pr01;

public class ServerResponse<T> {
    private final T data;
    private final boolean success;

    public ServerResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }
    public void print() {
        System.out.println("Успех: " + success + ", Данные: " + data);
    }
}