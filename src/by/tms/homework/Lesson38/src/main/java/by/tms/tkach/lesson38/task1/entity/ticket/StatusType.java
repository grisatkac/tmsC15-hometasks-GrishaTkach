package by.tms.tkach.lesson38.task1.entity.ticket;

public enum StatusType {

    PENDING("PENDING"),
    PERFORMS("PERFORMS"),
    COMPLETED("COMPLETED");

    private String value;

    StatusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
