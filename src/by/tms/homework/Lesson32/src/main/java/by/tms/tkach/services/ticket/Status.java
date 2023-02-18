package by.tms.tkach.services.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;

public interface Status {

    void setStatus(Ticket ticket, StatusType statusType);
}
