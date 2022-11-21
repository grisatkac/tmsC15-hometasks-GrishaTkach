package by.tms.tkach.entity.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicket {

    static Ticket ticket;

    @BeforeAll
    public static void init() {
        ticket = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketPending() {
        StatusType expected = StatusType.PENDING;
        ticket.setStatus(StatusType.PENDING);
        assertEquals(expected, ticket.getStatus());
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketInProgress() {
        StatusType expected = StatusType.IN_PROGRESS;
        ticket.setStatus(StatusType.IN_PROGRESS);
        assertEquals(expected, ticket.getStatus());
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketCompleted() {
        StatusType expected = StatusType.COMPLETED;
        ticket.setStatus(StatusType.COMPLETED);
        assertEquals(expected, ticket.getStatus());
    }
}
