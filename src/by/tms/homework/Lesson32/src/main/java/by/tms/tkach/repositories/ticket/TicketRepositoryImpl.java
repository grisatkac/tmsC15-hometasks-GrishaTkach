package by.tms.tkach.repositories.ticket;

import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.CrudRepository;
import by.tms.tkach.utils.identity.TicketIdentityUtil;
import by.tms.tkach.utils.log.LogUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TicketRepositoryImpl implements Serializable, CrudRepository<Ticket> {

    @Serial
    private static final long serialVersionUID = 6306550843968050101L;
    private static final Map<Long, Ticket> TICKET_REPOSITORY = TicketRepository.getTICKET_REPOSITORY();

    @Override
    public boolean add(Ticket ticket) {
        boolean resultOfAdding = false;
        if (ticket != null) {
            TICKET_REPOSITORY.put(ticket.getId(), ticket);
            resultOfAdding = true;
        }

        LogUtil.printInfo("Result of adding user in perository is: " + resultOfAdding);

        return resultOfAdding;
    }

    @Override
    public Ticket find(long id) {

        boolean isValidId = checkValidId(id);

        if (!isValidId) {
            return null;
        }

        Optional<Map.Entry<Long, Ticket>> foundCandidateTicket = TICKET_REPOSITORY.entrySet().stream()
                .filter(ticket -> ticket.getKey() == id)
                .findFirst();

        Ticket ticket = foundCandidateTicket.map(Map.Entry::getValue).orElse(null);
        LogUtil.printInfo("Result of searching ticket in repository is: " + ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(TICKET_REPOSITORY.values());
    }

    @Override
    public boolean update(Ticket ticket, long id) {
        boolean resultOfUpdating = false;
        boolean isValidId = checkValidId(id);

        if (ticket == null) {
            LogUtil.printInfo("Ticket object is null");
            return resultOfUpdating;
        }

        if (!isValidId) {
            return resultOfUpdating;
        }

        ticket.setId(id);
        TICKET_REPOSITORY.put(id, ticket);
        TicketIdentityUtil.decrementId();
        resultOfUpdating = true;
        LogUtil.printInfo("The result of updating ticket in repository is: " + resultOfUpdating);

        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean isValidId = checkValidId(id);
        boolean resultOfDeleting = false;

        if (!isValidId) {
            return resultOfDeleting;
        }

        resultOfDeleting = TICKET_REPOSITORY.values().removeIf(ticket -> ticket.getId() == id);
        LogUtil.printInfo("The result of deleting ticket from repository is: " + resultOfDeleting);
        return resultOfDeleting;
    }

    private boolean checkValidId(long id) {
        if (id < 1 || id > TICKET_REPOSITORY.size()) {
            LogUtil.printInfo("Incorrect user id: " + id);
            return false;
        }

        return true;
    }
}
