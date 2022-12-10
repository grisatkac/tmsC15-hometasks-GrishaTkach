package by.tms.helpdesk.lesson34.repositories.ticket;

import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.repositories.AbstractRepository;
import by.tms.helpdesk.lesson34.repositories.CrudRepository;
import by.tms.helpdesk.lesson34.repositories.Repository;

import java.util.List;

public interface TicketRepository extends AbstractRepository<Ticket> {
    List<Ticket> findByStatus(Long userId, String status);
}
