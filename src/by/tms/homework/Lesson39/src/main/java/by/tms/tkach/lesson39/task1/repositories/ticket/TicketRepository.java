package by.tms.tkach.lesson39.task1.repositories.ticket;

import by.tms.tkach.lesson39.task1.entities.ticket.Ticket;
import by.tms.tkach.lesson39.task1.repositories.AbstractRepository;

import java.util.List;

public interface TicketRepository extends AbstractRepository<Ticket> {
    List<Ticket> findByStatus(Long userId, String status);
}
