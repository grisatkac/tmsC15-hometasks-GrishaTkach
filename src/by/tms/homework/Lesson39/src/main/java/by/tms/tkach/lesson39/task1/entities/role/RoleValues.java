package by.tms.tkach.lesson39.task1.entities.role;

public enum RoleValues {

    USER("USER"),
    ADMIN("ADMIN");

    private String value;

    RoleValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
