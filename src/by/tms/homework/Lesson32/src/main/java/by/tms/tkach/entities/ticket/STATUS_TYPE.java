package by.tms.tkach.entities.ticket;

public enum STATUS_TYPE {

    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED");

    private final String value;

    STATUS_TYPE(String value) {
        this.value = value;
    }
}
