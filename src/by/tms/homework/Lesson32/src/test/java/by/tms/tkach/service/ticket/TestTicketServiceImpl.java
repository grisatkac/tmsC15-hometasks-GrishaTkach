package by.tms.tkach.service.ticket;

import by.tms.tkach.entities.ticket.StatusType;
import by.tms.tkach.entities.ticket.Ticket;
import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.ticket.TicketServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTicketServiceImpl {

    static TicketServiceImpl ticketService;
    static Ticket ticket;
    static Ticket ticketForUpdate;

    @BeforeAll
    public static void init() {
        ticketService = new TicketServiceImpl();
        ticket = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();
        ticketForUpdate = Ticket.builder()
                .title("title1")
                .description("description1")
                .status(StatusType.IN_PROGRESS)
                .owner(null)
                .executor(null)
                .build();

        ticketForUpdate.setId(1);
    }

    public static Stream<Arguments> testGetById() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(100, false),
                Arguments.of(-100, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetById")
    public void getByIdTest(long id, boolean expected) {
        boolean actual = false;
        Ticket foundTicket = ticketService.getById(id);

        if (foundTicket != null) {
            actual = true;
        }

        assertEquals(expected, actual);
    }


    public static Stream<Arguments> testCreate() {
        return Stream.of(
                Arguments.of(
                        ticket.getTitle(),
                        ticket.getDescription(),
                        ticket.getStatus(),
                        ticket.getOwner(),
                        ticket.getExecutor(),
                        true
                ),
                Arguments.of(
                        ticket.getTitle(),
                        "",
                        ticket.getStatus(),
                        ticket.getOwner(),
                        ticket.getExecutor(),
                        false
                ),
                Arguments.of(
                        null,
                        ticket.getDescription(),
                        ticket.getStatus(),
                        ticket.getOwner(),
                        ticket.getExecutor(),
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCreate")
    public void createTest(String title, String description, StatusType status, User owner, User executor, boolean expected) {
        boolean actual = ticketService.create(title, description, status, owner, executor);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> updateTest() {
        return Stream.of(
                Arguments.of(ticketForUpdate, 1, true),
                Arguments.of(null, 1, false),
                Arguments.of(ticketForUpdate, -4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("updateTest")
    public void testUpdate(Ticket receiveTicket, long id, boolean expected) {
        boolean actual = ticketService.update(receiveTicket, id);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> deleteTest() {
        return Stream.of(
                Arguments.of( 1, true),
                Arguments.of( -5, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("deleteTest")
    public void testDelete(long id, boolean expected) {
        boolean actual = ticketService.delete(id);

        assertEquals(expected, actual);

    }
}
