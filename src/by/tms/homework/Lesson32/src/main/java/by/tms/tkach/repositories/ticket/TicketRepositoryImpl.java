package by.tms.tkach.repositories.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.utils.identity.TicketIdentityUtil;
import by.tms.tkach.utils.log.LogUtil;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class TicketRepositoryImpl implements Serializable, TicketRepository {

    @Serial
    private static final long serialVersionUID = 6306550843968050101L;
    private final Map<Long, Ticket> TICKET_REPOSITORY = new HashMap<>();

    {
        generateEntitiesForRepository();
    }

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
    public boolean update(Ticket ticket) {
        boolean resultOfUpdating;
        TICKET_REPOSITORY.put(ticket.getId(), ticket);
        resultOfUpdating = true;
        LogUtil.printInfo("The result of updating ticket in repository is: " + resultOfUpdating);
        return resultOfUpdating;
    }

    @Override
    public boolean delete(long id) {
        boolean resultOfDeleting = false;
        resultOfDeleting = TICKET_REPOSITORY.values().removeIf(ticket -> ticket.getId() == id);
        resultOfDeleting = true;
        LogUtil.printInfo("The result of deleting ticket from repository is: " + resultOfDeleting);
        return resultOfDeleting;
    }


    @Override
    public void generateEntitiesForRepository() {
        Ticket ticket1 = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();

        Ticket ticket2 = Ticket.builder()
                .title("title2")
                .description("description2")
                .status(StatusType.PENDING)
                .owner(null)
                .executor(null)
                .build();

        Ticket ticket3 = Ticket.builder()
                .title("title3")
                .description("description3")
                .status(StatusType.COMPLETED)
                .owner(null)
                .executor(null)
                .build();

        TICKET_REPOSITORY.put(ticket1.getId(), ticket1);
        TICKET_REPOSITORY.put(ticket2.getId(), ticket2);
        TICKET_REPOSITORY.put(ticket3.getId(), ticket3);
    }

    @Override
    public Map<Long, Ticket> getRepository() {
        return TICKET_REPOSITORY;
    }
}
