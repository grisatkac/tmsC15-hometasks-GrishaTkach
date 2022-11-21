package by.tms.tkach.entities.ticket;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.utils.identity.TicketIdentityUtil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {

    private long id;
    private String title;
    private String description;
    private StatusType status;
    private User owner;
    private User executor;

    public Ticket(String title, String description, StatusType status, User owner, User executor) {
        this.id = TicketIdentityUtil.generateId();
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = owner;
        this.executor = executor;
    }
}
