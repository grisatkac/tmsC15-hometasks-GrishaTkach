package by.tms.tkach.repositories.ticket;

import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.repositories.CrudRepository;
import by.tms.tkach.repositories.Repository;

public interface TicketRepository extends CrudRepository<Ticket>, Repository<Ticket> {
}
