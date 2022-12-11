package by.tms.tkach.repostitory;

import by.tms.helpdesk.lesson34.entities.role.Role;
import by.tms.helpdesk.lesson34.entities.role.RoleValues;
import by.tms.helpdesk.lesson34.entities.ticket.StatusType;
import by.tms.helpdesk.lesson34.entities.ticket.Ticket;
import by.tms.helpdesk.lesson34.entities.user.User;
import by.tms.helpdesk.lesson34.repositories.user.UserRepository;
import by.tms.helpdesk.lesson34.repositories.user.UserRepositoryImpl;
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


public class TestUserRepositoryImpl {

    static UserRepository userRepository;
    static User newUser;
    static User existUser;
    static Long existUserId;
    static Long newUserId;
    static User userForUpdate;

    @BeforeAll
    public static void init() {
        userRepository = new UserRepositoryImpl();

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

    public static Stream<Arguments> testAdd() {
        return Stream.of(
                Arguments.of(newUser, true),
                Arguments.of(existUser, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testAdd")
    @Tag("Test add user")
    public void addTest(User receiveUser, boolean expected) {
        boolean actual = userRepository.add(receiveUser);
        assertEquals(expected, actual);
    }


    public static Stream<Arguments> testFindById() {
        return Stream.of(
                Arguments.of(newUser.getId(), false),
                Arguments.of(existUser.getId(), true),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFindById")
    @Tag("Test find user by id")
    public void findByIdTest(Long id, boolean expected) {
        boolean actual = false;
        User foundUser = userRepository.find(id);

        if (foundUser != null) {
            actual = id == foundUser.getId();
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testFindByEmail() {
        return Stream.of(
                Arguments.of(newUser.getEmail(), false),
                Arguments.of(existUser.getEmail(), true),
                Arguments.of("", false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFindByEmail")
    @Tag("Test find user by email")
    public void findByEmailTest(String email, boolean expected) {
        boolean actual = false;
        User foundUser = userRepository.find(email);

        if (foundUser != null) {
            actual = email.equals(foundUser.getEmail());
        }

        assertEquals(expected, actual);
    }

    @Test
    @Tag("Test find all users")
    public void findAllTest() {
        List<User> existList = new ArrayList<>();

        Role role = new Role(RoleValues.USER);
        role.setId(1L);
        User existUser = User.builder()
                .name("user")
                .surname("surname")
                .email("user@gmail.com")
                .password("pass")
                .canDoJob(true)
                .role(role)
                .build();
        existUserId = 1L;
        existUser.setId(existUserId);

        Role role1 = new Role(RoleValues.ADMIN);
        role1.setId(2L);
        User existUser1 = User.builder()
                .name("admin")
                .surname("surname")
                .email("admin@gmail.com")
                .password("pass")
                .canDoJob(true)
                .role(role1)
                .build();
        existUser1.setId(2L);
        existList.add(existUser);
        existList.add(existUser1);

        List<User> foundListOfAllUsers = userRepository.findAll();

        assertEquals(existList, foundListOfAllUsers);
    }

    public static Stream<Arguments> testUpdate() {
        return Stream.of(
                Arguments.of(userForUpdate, existUserId, true),
                Arguments.of(userForUpdate, 100L, false),
                Arguments.of(null, existUserId, false),
                Arguments.of(userForUpdate, null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testUpdate")
    public void updateTest(User user, Long id, boolean expected) {
        boolean actual;
        if (user != null) {
            user.setId(id);
        }

        actual = userRepository.update(user);

        if (actual) {
            System.out.println("found user after updating: " + userRepository.find(id));
            actual = userRepository.find(id).equals(user);
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testDelete() {
        return Stream.of(
                Arguments.of(existUserId, true),
                Arguments.of(newUserId, false),
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDelete")
    public void deleteTest(Long id, boolean expected) {
        User foundUser = null;
        boolean actual = false;
        boolean user_ticket = false;

        actual = userRepository.delete(id);

        if (actual) {
            foundUser =  userRepository.find(id);
        }

        if (foundUser == null && actual) {
            actual = true;
        } else {
            actual = false;
        }

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
        User user = userRepository.login(email, password);

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
        User registratedUser = userRepository.registrateUser(user);

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
        User foundUser = userRepository.logOut(user);
        if (foundUser != null) {
            actual = true;
        }
        assertEquals(expected, actual);
    }
}
