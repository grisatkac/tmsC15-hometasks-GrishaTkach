package by.tms.tkach.repositories.ticket;

import by.tms.tkach.entities.ticket.STATUS_TYPE;
import by.tms.tkach.entities.ticket.Ticket;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class TicketRepository implements Serializable {

    @Serial
    private static final long serialVersionUID = 8876700277146324268L;
    private static final Map<Long, Ticket> TICKET_REPOSITORY = new HashMap<>();

    public static Map<Long, Ticket> getTICKET_REPOSITORY() {
        return TICKET_REPOSITORY;
    }

    static {
        generateTickets();
    }

    private static void generateTickets(){
        Ticket ticket1 = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(STATUS_TYPE.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();

        Ticket ticket2 = Ticket.builder()
                .title("title2")
                .description("description2")
                .status(STATUS_TYPE.PENDING)
                .owner(null)
                .executor(null)
                .build();

        Ticket ticket3 = Ticket.builder()
                .title("title3")
                .description("description3")
                .status(STATUS_TYPE.COMPLETED)
                .owner(null)
                .executor(null)
                .build();

        TICKET_REPOSITORY.put(ticket1.getId(), ticket1);
        TICKET_REPOSITORY.put(ticket2.getId(), ticket2);
        TICKET_REPOSITORY.put(ticket3.getId(), ticket3);
    }
}
