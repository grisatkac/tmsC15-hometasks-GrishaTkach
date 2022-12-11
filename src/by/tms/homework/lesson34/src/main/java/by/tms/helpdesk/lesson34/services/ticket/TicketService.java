package by.tms.helpdesk.lesson34.services.ticket;

import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.services.AbstractService;
import by.tms.helpdesk.lesson34.services.CrudService;

import java.util.List;

public interface TicketService extends AbstractService<Ticket> {

    List<Ticket> getByStatus(Long userId, String status);
}
