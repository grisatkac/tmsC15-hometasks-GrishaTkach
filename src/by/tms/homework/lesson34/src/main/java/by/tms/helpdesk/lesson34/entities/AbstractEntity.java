package by.tms.helpdesk.lesson34.entities;


import by.tms.helpdesk.lesson34.utils.identity.IdentityUtils;
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
