package by.tms.tkach.services.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.ticket.TicketRepositoryImpl;
import by.tms.tkach.utils.identity.TicketIdentityUtil;
import by.tms.tkach.utils.log.LogUtil;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();

    @Override
    public boolean create(Ticket ticket) {
        boolean isTicketAdded = false;

        if (ticket.getTitle() == null ||ticket.getDescription() == null) {
            LogUtil.printInfo("Required parameters of ticket is null");
            return isTicketAdded;
        }

        if (ticket.getTitle().isEmpty() || ticket.getDescription().isEmpty()) {
            LogUtil.printInfo("Required parameters of ticket is empty");
            return isTicketAdded;
        }

        isTicketAdded = ticketRepository.add(ticket);
        LogUtil.printInfo("Result of adding new ticket is: " + isTicketAdded);
        return isTicketAdded;
    }

    @Override
    public void setStatus(Ticket ticket, StatusType statusType) {
        ticket.setStatus(statusType);
    }

    @Override
    public Ticket getById(long id) {
        if (!checkValidId(id)) {
            LogUtil.printInfo("Invalid id");
            return null;
        }

        Ticket resultOfGettingById = ticketRepository.find(id);
        LogUtil.printInfo("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public boolean update(Ticket ticket, long id) {
        boolean resultOfUpdating = false;

        if (ticket == null) {
            LogUtil.printInfo("Ticket object is null");
            return resultOfUpdating;
        }

        if (!checkValidId(ticket.getId())) {
            return resultOfUpdating;
        }

        ticket.setId(id);
        resultOfUpdating = ticketRepository.update(ticket);
        TicketIdentityUtil.decrementId();
        LogUtil.printInfo("Result of updating ticket is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean resultOfDeleting = false;

        if (!checkValidId(id)) {
            return resultOfDeleting;
        }

         resultOfDeleting = ticketRepository.delete(id);
        LogUtil.printInfo("Result of deleting ticket is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidId(long id) {
        if (id < 1 || id > ticketRepository.getRepository().size()) {
            LogUtil.printInfo("Incorrect user id: " + id);
            return false;
        }

        return true;
    }
}
