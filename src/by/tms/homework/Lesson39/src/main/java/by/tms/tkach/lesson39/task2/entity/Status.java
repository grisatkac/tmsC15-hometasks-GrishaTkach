package by.tms.tkach.lesson39.task2.entity;

public enum Status {

    TO_DO("To Do"),
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
