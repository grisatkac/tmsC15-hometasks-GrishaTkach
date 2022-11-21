package by.tms.tkach.repository.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.repositories.ticket.TicketRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestTicketRepositoryImpl {

    static TicketRepositoryImpl ticketRepository;
    static Ticket ticket;

    @BeforeAll
    public static void init() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();
    }

    public static Stream<Arguments> testAdd() {
        return Stream.of(
                Arguments.of(ticket, true),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testAdd")
    @Tag("Test add ticket in repository")
    public void add(Ticket ticket, boolean expected) {
        boolean actual = false;
        if (ticket != null) {
            actual = ticketRepository.add(ticket);
        }

        if (actual) {
            Ticket foundTicket = ticketRepository.find(ticket.getId());
            actual = foundTicket.equals(ticket);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testFind() {
        return Stream.of(
                Arguments.of(3, true),
                Arguments.of(-10, false),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFind")
    @Tag("test find")
    public void find(long id, boolean expected) {
        Ticket foundTicket = ticketRepository.find(id);
        boolean actual = foundTicket != null;

        if (actual) {
            actual = id == foundTicket.getId();
        }

        assertEquals(expected, actual);
    }

    @Test
    @Tag("test findAll")
    public void findAll() {
        boolean expected = true;
        List<Ticket> ticketList = ticketRepository.findAll();
        List<Ticket> newList = new ArrayList<>(ticketRepository.getRepository().values());
        boolean actual = ticketList.equals(newList);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testUpdate() {
        return Stream.of(
                Arguments.of(ticket, 1, true),
                Arguments.of(null, 1, false),
                Arguments.of(ticket, -4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testUpdate")
    @Tag("Test update")
    public void update(Ticket ticket, long id, boolean expected) {
        boolean actual = ticketRepository.update(ticket, id);
        if (actual) {
            actual = ticketRepository.find(id).equals(ticket);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testDelete() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(1000, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDelete")
    @Tag("Test delete")
    public void delete(long id, boolean expected) {
        Ticket foundTicket = null;
        boolean actual = false;

        actual = ticketRepository.delete(id);

        if (actual) {
            foundTicket =  ticketRepository.find(id);
        }

        if (foundTicket == null && actual) {
            actual = true;
        } else {
            actual = false;
        }

        assertEquals(expected, actual);
    }
}
