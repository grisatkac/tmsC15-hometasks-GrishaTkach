package by.tms.tkach.service;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.services.user.UserService;
import by.tms.helpdesk.lesson34.services.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserServiceImpl {

    static UserService userService;
    static User user;
    static User userForUpdate;
    static User newUser;
    static Long newUserId;
    static User existUser;
    static Long existUserId;

    @BeforeAll
    public static void init() {

        userService = new UserServiceImpl();


        newUser = User.builder()
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .canDoJob(true)
                .role(new Role(RoleValues.USER))
                .build();
        newUserId = 100L;
        newUser.setId(newUserId);

        Role role = new Role(RoleValues.USER);
        role.setId(1L);
        existUser = User.builder()
                .name("user")
                .surname("surname")
                .email("user@gmail.com")
                .password("pass")
                .canDoJob(true)
                .role(role)
                .build();
        existUserId = 1L;
        existUser.setId(existUserId);

        List<Ticket> existTickets = new ArrayList<>();
        Ticket existTicket = new Ticket("title1", "description1", StatusType.COMPLETED, null, null);
        existTicket.setId(1L);
        existTickets.add(existTicket);

        userForUpdate = User.builder()
                .name("user")
                .surname("updated surname")
                .email("user@gmail.com")
                .password("pass")
                .canDoJob(false)
                .role(role)
                .tickets(existTickets)
                .build();
        userForUpdate.setId(existUserId);
    }

    public static Stream<Arguments> testCreate() {
        return Stream.of(
                Arguments.of(
                        newUser, true
                ),
                Arguments.of(
                        new User(
                                "",
                                user.getSurname(),
                                user.getEmail(),
                                null, user.isCanDoJob(),
                                null,
                                null),
                        false
                ),
                Arguments.of(existUser, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCreate")
    @Tag("Test create")
    public void create(User receiveUser, boolean expected) {
        boolean actual = userService.create(receiveUser);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testGetById() {
        return Stream.of(
                Arguments.of(newUserId, false),
                Arguments.of(existUserId, true),
                Arguments.of(null, false),
                Arguments.of(100L, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetById")
    @Tag("Test getById")
    public void getById(Long id, boolean expected) {
        boolean actual = false;

        User foundUser = userService.getById(id);
        if (foundUser != null) {
            actual = true;
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> updateTest() {
        return Stream.of(
                Arguments.of(newUser, false),
                Arguments.of(null,  false),
                Arguments.of(userForUpdate,  true)
        );
    }

    @ParameterizedTest
    @MethodSource("updateTest")
    public void testUpdate(User receiveUser, boolean expected) {
        boolean actual = userService.update(receiveUser);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> deleteTest() {
        return Stream.of(
                Arguments.of( null, false),
                Arguments.of( -5L, false),
                Arguments.of(existUserId, true)
        );
    }

    @ParameterizedTest
    @MethodSource("deleteTest")
    public void testDelete(Long id, boolean expected) {
        boolean actual = userService.delete(id);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testLogin() {
        return Stream.of(
                Arguments.of(existUser.getEmail(),existUser.getPassword(), true),
                Arguments.of(null, existUser.getPassword(), false),
                Arguments.of(existUser.getEmail(), null, false),
                Arguments.of(newUser.getEmail(), existUser.getPassword(), false),
                Arguments.of(existUser.getEmail(), newUser.getPassword(), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testLogin")
    public void loginTest(String email, String password, boolean expected) {
        boolean actual;
        User user = userService.login(email, password);

        if (user == null) {
            actual = false;
        } else {
            actual = true;
        }

        assertEquals(expected, actual);

    }

    public static Stream<Arguments> testRegistrate() {
        return Stream.of(
                Arguments.of(newUser, true),
                Arguments.of(null, false),
                Arguments.of(existUser, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testRegistrate")
    public void registrateTest(User user, boolean expected) {
        boolean actual = false;
        User registratedUser = userService.registrateUser(user);

        if (registratedUser != null) {
            actual = true;
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testLogOut() {
        return Stream.of(
                Arguments.of(newUser, false),
                Arguments.of(null, false),
                Arguments.of(existUser, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testLogOut")
    public void logOutTest(User user, boolean expected) {
        boolean actual = false;
        User foundUser = userService.logOut(user);
        if (foundUser != null) {
            actual = true;
        }
        assertEquals(expected, actual);
    }
}
