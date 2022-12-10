package by.tms.helpdesk.lesson34.entities.ticket;

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
