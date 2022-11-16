package by.tms.tkach.entity.ticket;

import by.tms.tkach.entities.ticket.STATUS_TYPE;
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
                .status(STATUS_TYPE.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketPending() {
        STATUS_TYPE expected = STATUS_TYPE.PENDING;
        ticket.makeTicketPending();
        assertEquals(expected, ticket.getStatus());
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketInProgress() {
        STATUS_TYPE expected = STATUS_TYPE.IN_PROGRESS;
        ticket.makeTicketInProgress();
        assertEquals(expected, ticket.getStatus());
    }

    @Test
    @Tag("Test makeTicketPending")
    public void makeTicketCompleted() {
        STATUS_TYPE expected = STATUS_TYPE.COMPLETED;
        ticket.makeTicketCompleted();
        assertEquals(expected, ticket.getStatus());
    }
}
