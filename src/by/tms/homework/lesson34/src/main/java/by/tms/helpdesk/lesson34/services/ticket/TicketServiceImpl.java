package by.tms.helpdesk.lesson34.services.ticket;

import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.repositories.ticket.TicketRepositoryImpl;
import by.tms.helpdesk.lesson34.utils.identity.TicketIdentityUtil;
import by.tms.helpdesk.lesson34.utils.log.LogUtil;
import java.util.List;

public class TicketServiceImpl implements TicketService{

    private final TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();

    @Override
    public boolean create(Ticket ticket) {
        boolean isTicketAdded = false;

        if (!checkValidParams(ticket)) {
            LogUtil.printInfo("Empty information about ticket");
            return false;
        }

        isTicketAdded = ticketRepository.add(ticket);
        LogUtil.printInfo("Result of adding new ticket is: " + isTicketAdded);
        return isTicketAdded;
    }

    @Override
    public Ticket getById(Long id) {
        if (id == null) {
            LogUtil.printInfo("Invalid id");
            return null;
        }

        Ticket resultOfGettingById = ticketRepository.find(id);
        LogUtil.printInfo("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }

    @Override
    public List<Ticket> getByStatus(Long userId, String status) {
        List<Ticket> foundTickets = null;
        if (userId != null || status != null || !status.isEmpty()) {
            foundTickets = ticketRepository.findByStatus(userId, status);
        }

        return foundTickets;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public boolean update(Ticket ticket) {
        boolean resultOfUpdating = false;

        if (!checkValidParams(ticket)) {
            LogUtil.printInfo("INVALID PARAMS");
            return resultOfUpdating;
        }

        ticket.setId(ticket.getId());
        resultOfUpdating = ticketRepository.update(ticket);
        TicketIdentityUtil.decrementId();
        LogUtil.printInfo("Result of updating ticket is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(Long id) {
        boolean resultOfDeleting = false;

        if (id == null) {
            return resultOfDeleting;
        }

        resultOfDeleting = ticketRepository.delete(id);
        LogUtil.printInfo("Result of deleting ticket is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidParams(Ticket ticket) {
        if (ticket == null) {
            LogUtil.printInfo("first");
            return false;
        }

        if (ticket.getTitle() == null || ticket.getDescription() == null || ticket.getStatus() == null) {
            LogUtil.printInfo("second");
            return false;
        }

        if (ticket.getTitle().isEmpty() || ticket.getDescription().isEmpty() || ticket.getStatus().getValue().isEmpty()) {
            LogUtil.printInfo("third");
            return false;
        }

        return true;
    }
}
