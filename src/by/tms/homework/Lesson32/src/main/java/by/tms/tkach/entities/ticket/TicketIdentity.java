package by.tms.tkach.entities.ticket;

import by.tms.tkach.utils.identity.TicketIdentityUtil;
import lombok.Data;

@Data
public class TicketIdentity {

    private long id;

    public TicketIdentity() {
        this.id = TicketIdentityUtil.generateId();
    }
}
