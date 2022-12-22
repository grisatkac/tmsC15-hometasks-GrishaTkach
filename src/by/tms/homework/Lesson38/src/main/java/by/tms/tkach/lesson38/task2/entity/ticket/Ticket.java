package by.tms.tkach.lesson38.task2.entity.ticket;

import by.tms.tkach.lesson38.task2.entity.AbstractEntity;
import by.tms.tkach.lesson38.task2.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Ticket extends AbstractEntity implements Cloneable {

    private String title;
    private String description;
    private StatusType status;
    private User owner;
    private User executor;

    public Ticket(String title, String description, StatusType status, User owner, User executor) {
        super();
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = owner;
        this.executor = executor;
    }

    public Ticket(Long id, String title, String description, StatusType status, User owner, User executor) {
        super(id);
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = owner;
        this.executor = executor;
    }

    @Override
    public Ticket clone() {
        try {
            return (Ticket) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
