package by.tms.tkach.lesson38.task2.entity;


import by.tms.tkach.lesson38.task1.utils.IdentityUtils;
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
