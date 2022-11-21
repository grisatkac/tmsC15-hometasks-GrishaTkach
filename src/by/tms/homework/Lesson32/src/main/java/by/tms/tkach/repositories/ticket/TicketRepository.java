package by.tms.tkach.repositories.ticket;

import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.repositories.CrudRepository;
import java.util.Map;

public interface TicketRepository extends CrudRepository<Ticket> {
    void generateTickets();
    Map<Long, Ticket> getTICKET_REPOSITORY();
}
