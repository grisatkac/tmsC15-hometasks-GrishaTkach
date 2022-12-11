package by.tms.helpdesk.lesson34.repositories;

import lombok.ToString;

public enum RepositoryProperties {

    URL("jdbc:mysql://localhost:3306/helpdesk"),
    USER("root"),
    PASSWORD("ghblevfyysq gfhjkm}");

    private final String value;

    RepositoryProperties(String value) {
        this.value = value;
    }

    public String getProperty() {
        return value;
    }

}
