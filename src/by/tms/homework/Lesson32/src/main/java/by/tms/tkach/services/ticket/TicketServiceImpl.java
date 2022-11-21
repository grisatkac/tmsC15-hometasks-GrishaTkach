package by.tms.tkach.services.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.ticket.TicketRepositoryImpl;
import by.tms.tkach.utils.identity.TicketIdentityUtil;
import by.tms.tkach.utils.log.LogUtil;

import java.util.List;

public class TicketServiceImpl implements TicketService {

    private final TicketRepositoryImpl ticketCrud = new TicketRepositoryImpl();

    @Override
    public boolean create(String title, String description, StatusType status, User owner, User executor) {
        boolean isTicketAdded = false;

        if (title == null ||description == null) {
            LogUtil.printInfo("Required parameters of ticket is null");
            return isTicketAdded;
        }

        if (title.isEmpty() || description.isEmpty()) {
            LogUtil.printInfo("Required parameters of ticket is empty");
            return isTicketAdded;
        }

        Ticket ticket = Ticket.builder()
                .title(title).description(description).status(status).owner(owner).executor(executor)
                .build();
        isTicketAdded = ticketCrud.add(ticket);
        LogUtil.printInfo("Result of adding new ticket is: " + isTicketAdded);
        return isTicketAdded;
    }

    @Override
    public Ticket getById(long id) {
        Ticket resultOfGettingById = ticketCrud.find(id);
        LogUtil.printInfo("Result of getting ticket by id is: " + resultOfGettingById);
        return resultOfGettingById;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketCrud.findAll();
    }

    @Override
    public boolean update(Ticket ticket, long id) {
        boolean resultOfUpdating = false;

        if (ticket != null) {
            resultOfUpdating = ticketCrud.update(ticket, id);
            TicketIdentityUtil.decrementId();
        }

        LogUtil.printInfo("Result of updating ticket is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean resultOfDeleting = ticketCrud.delete(id);
        LogUtil.printInfo("Result of updating ticket is: " + resultOfDeleting);
        return resultOfDeleting;
    }
}