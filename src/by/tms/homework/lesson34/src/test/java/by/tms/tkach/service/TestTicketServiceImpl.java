package by.tms.tkach.service;

import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.repositories.ticket.TicketRepository;
import by.tms.helpdesk.lesson34.repositories.ticket.TicketRepositoryImpl;
import by.tms.helpdesk.lesson34.services.ticket.TicketService;
import by.tms.helpdesk.lesson34.services.ticket.TicketServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicketServiceImpl {

    static TicketService ticketService;
    static Ticket ticket;
    static Ticket existTicket;
    static Long existTicketId;
    static Long userId;
    static Ticket ticketForUpdate;

    @BeforeAll
    public static void init() {
        userId = 1L;
        ticketService = new TicketServiceImpl();
        ticket = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.COMPLETED)
                .build();
        existTicketId = 1L;
        existTicket = new Ticket(existTicketId, "title1", "description1",StatusType.COMPLETED, null, null);

        ticketForUpdate = new Ticket("updated title", "description1", StatusType.PENDING, null, null);
        ticketForUpdate.setId(1L);

    }

    public static Stream<Arguments> testCreate() {
        return Stream.of(
                Arguments.of(ticket, true),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCreate")
    @Tag("Test create ticket in repository")
    public void create(Ticket ticket, boolean expected) {
        boolean actual = false;
        if (ticket != null) {
            actual = ticketService.create(ticket);
        }

        if (actual) {
            Ticket foundTicket = ticketService.getById(ticket.getId());
            actual = foundTicket.equals(ticket);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testGetById() {
        return Stream.of(
                Arguments.of(existTicketId, true),
                Arguments.of(-10L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetById")
    @Tag("test get by id")
    public void find(Long id, boolean expected) {
        Ticket foundTicket = ticketService.getById(id);
        boolean actual = foundTicket != null;

        if (actual) {
            actual = Objects.equals(id, foundTicket.getId());
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testGetByStatus() {
        return Stream.of(
                Arguments.of(existTicketId, true),
                Arguments.of(-10L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetByStatus")
    @Tag("test find")
    public void findByStatus(Long userId,  boolean expected) {
        boolean actual = false;
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(existTicket);
        List<Ticket> foundTickets = ticketService.getByStatus(userId, existTicket.getStatus().getValue());

        if (foundTickets != null) {
            actual = foundTickets.equals(ticketList);
        }
        assertEquals(expected, actual);
    }


    @Test
    @Tag("Test find all users")
    public void findAllTest() {
        List<Ticket> existList = new ArrayList<>();

        Ticket existTicket1 = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.COMPLETED)
                .build();
        existTicket1.setId(1L);

        Ticket existTicket2 = Ticket.builder()
                .title("title2")
                .description("description2")
                .status(StatusType.COMPLETED)
                .build();
        existTicket2.setId(2L);

        Ticket existTicket3 = Ticket.builder()
                .title("title3")
                .description("description3")
                .status(StatusType.PERFORMS)
                .build();
        existTicket3.setId(3L);

        Ticket existTicket4 = Ticket.builder()
                .title("title4")
                .description("description4")
                .status(StatusType.COMPLETED)
                .build();
        existTicket4.setId(4L);

        existList.add(existTicket1);
        existList.add(existTicket2);
        existList.add(existTicket3);
        existList.add(existTicket4);



        List<Ticket> foundListOfAllTickets = ticketService.getAll();

        assertEquals(existList, foundListOfAllTickets);
    }

    public static Stream<Arguments> testUpdate() {
        return Stream.of(
                Arguments.of(ticketForUpdate, existTicketId, true),
                Arguments.of(ticketForUpdate, 100L, false),
                Arguments.of(null, existTicketId, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testUpdate")
    public void updateTest(Ticket ticket, Long id, boolean expected) {
        boolean actual;

        if (ticket != null) {
            ticket.setId(id);
        }

        actual = ticketService.update(ticket);

        if (actual) {
            System.out.println("found user after updating: " + ticketService.getById(id));
            actual = ticketService.getById(id).equals(ticket);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testDelete() {
        return Stream.of(
                Arguments.of(existTicketId, true),
                Arguments.of(100L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDelete")
    public void deleteTest(Long id, boolean expected) {
        Ticket foundTicket = null;
        boolean actual = false;

        actual = ticketService.delete(id);

        if (actual) {
            foundTicket =  ticketService.getById(id);
        }

        if (foundTicket == null && actual) {
            actual = true;
        } else {
            actual = false;
        }

        assertEquals(expected, actual);
    }
}
