package by.tms.tkach.services.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.Service;

public interface TicketService extends Service<Ticket>, Status {

    boolean create(String title, String description, StatusType status, User owner, User executor);
}
