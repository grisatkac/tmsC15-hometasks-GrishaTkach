package by.tms.tkach.entities.ticket;

import by.tms.tkach.utils.identity.TicketIdentityUtil;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class TicketIdentity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4186236123717862132L;
    private long id;

    public TicketIdentity() {
        this.id = TicketIdentityUtil.generateId();
    }
}
