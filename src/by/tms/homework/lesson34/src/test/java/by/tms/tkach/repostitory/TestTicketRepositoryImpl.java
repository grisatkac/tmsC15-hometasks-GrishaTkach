package by.tms.tkach.repostitory;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.repositories.ticket.TicketRepository;
import by.tms.helpdesk.lesson34.repositories.ticket.TicketRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicketRepositoryImpl {

    static TicketRepository ticketRepository;
    static Ticket ticket;
    static Ticket existTicket;
    static Long existTicketId;
    static Long userId;
    static Ticket ticketForUpdate;

    @BeforeAll
    public static void init() {
        userId = 1L;
        ticketRepository = new TicketRepositoryImpl();
        ticket = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.COMPLETED)
                .build();
        existTicketId = 1L;
        existTicket = new Ticket(existTicketId, "title1", "description1",StatusType.COMPLETED, null, null);

        ticketForUpdate = new Ticket("updated title", "description1", StatusType.PENDING, null, null);

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
                Arguments.of(existTicketId, true),
                Arguments.of(-10L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFind")
    @Tag("test find")
    public void find(Long id, boolean expected) {
        Ticket foundTicket = ticketRepository.find(id);
        boolean actual = foundTicket != null;

        if (actual) {
            actual = id == foundTicket.getId();
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testFindByStatus() {
        return Stream.of(
                Arguments.of(userId, true),
                Arguments.of(-10L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFind")
    @Tag("test find")
    public void findByStatus(Long userId,  boolean expected) {
        boolean actual = false;
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(existTicket);
        List<Ticket> foundTickets = ticketRepository.findByStatus(userId, existTicket.getStatus().getValue());

        if (foundTickets != null) {
            actual = foundTickets.equals(ticketList);
        }


        /*if (actual) {
            actual = userId == foundTicket.getId();
        }*/

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



        List<Ticket> foundListOfAllTickets = ticketRepository.findAll();

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

        actual = ticketRepository.update(ticket);

        if (actual) {
            System.out.println("found user after updating: " + ticketRepository.find(id));
            actual = ticketRepository.find(id).equals(ticket);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testDelete() {
        return Stream.of(
                Arguments.of(existTicket, true),
                Arguments.of(100L, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDelete")
    public void deleteTest(Long id, boolean expected) {
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
