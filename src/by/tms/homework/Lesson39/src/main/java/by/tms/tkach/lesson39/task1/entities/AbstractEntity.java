package by.tms.tkach.lesson39.task1.entities;

import by.tms.tkach.lesson39.task1.services.identity.IdentityUtils;
import lombok.Data;

@Data
public abstract class AbstractEntity {

    private Long id;

    public AbstractEntity() {
        this.id = IdentityUtils.generateId();
    }

    public AbstractEntity(Long id) {
        this.id = id;
    }
}
