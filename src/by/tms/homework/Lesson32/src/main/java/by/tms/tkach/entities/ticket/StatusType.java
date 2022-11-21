package by.tms.tkach.entities.ticket;

public enum StatusType {

    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private final String value;

    StatusType(String value) {
        this.value = value;
    }
}
