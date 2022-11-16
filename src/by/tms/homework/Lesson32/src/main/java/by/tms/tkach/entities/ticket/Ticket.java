package by.tms.tkach.entities.ticket;

import by.tms.tkach.entities.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Ticket extends TicketIdentity implements Serializable, Status {
    @Serial
    private static final long serialVersionUID = 5116469107617062955L;
    private String title;
    private String description;
    private STATUS_TYPE status;
    private User owner;
    private User executor;

    public Ticket(String title, String description, STATUS_TYPE status, User owner, User executor) {
        super();
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = owner;
        this.executor = executor;
    }

    @Override
    public void makeTicketPending() {
        this.status = STATUS_TYPE.PENDING;
    }

    @Override
    public void makeTicketInProgress() {
        this.status = STATUS_TYPE.IN_PROGRESS;
    }

    @Override
    public void makeTicketCompleted() {
        this.status = STATUS_TYPE.COMPLETED;
    }
}
