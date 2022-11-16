package by.tms.tkach.services.ticket;

import by.tms.tkach.entities.ticket.STATUS_TYPE;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.Service;

public interface TicketService extends Service<Ticket> {

    boolean create(String title, String description, STATUS_TYPE status, User owner, User executor);
}
