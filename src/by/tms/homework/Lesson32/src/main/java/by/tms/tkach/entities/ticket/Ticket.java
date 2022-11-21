package by.tms.tkach.entities.ticket;

import by.tms.tkach.entities.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Ticket extends TicketIdentity {

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
}
