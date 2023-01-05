package by.tms.tkach.lesson39.task1.services.ticket;

import by.tms.tkach.lesson39.task1.entities.ticket.Ticket;
import by.tms.tkach.lesson39.task1.services.AbstractService;

import java.util.List;

public interface TicketService extends AbstractService<Ticket> {

    List<Ticket> getByStatus(Long userId, String status);
}
