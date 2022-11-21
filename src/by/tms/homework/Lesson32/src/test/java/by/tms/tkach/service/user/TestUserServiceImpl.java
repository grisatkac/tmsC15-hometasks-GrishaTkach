package by.tms.tkach.service.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.services.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserServiceImpl {

    static UserServiceImpl userService;
    static User user;
    static User userForUpdate;

    @BeforeAll
    public static void init() {

        userService = new UserServiceImpl();
        user = User.builder()
                .name("name1")
                .surname("surname1")
                .email("user1@gmail.com")
                .login("login1")
                .password("password1")
                .canDoJob(true)
                .build();

        userForUpdate = User.builder()
                .name("name1")
                .surname("surname1")
                .email("user1@gmail.com")
                .login("login1")
                .password("password1")
                .canDoJob(true)
                .build();
        userForUpdate.setId(1);
    }

    public static Stream<Arguments> testCreate() {
        return Stream.of(
                Arguments.of(
                        user.getName(),
                        user.getSurname(),
                        user.getEmail(),
                        user.getLogin(),
                        user.getPassword(),
                        user.isCanDoJob(),
                        true
                ),
                Arguments.of(
                        "",
                        user.getSurname(),
                        user.getEmail(),
                        user.getLogin(),
                        null,
                        user.isCanDoJob(),
                        false
                ),
                Arguments.of(
                        user.getEmail(),
                        "",
                        null,
                        "",
                        user.getPassword(),
                        user.isCanDoJob(),
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCreate")
    @Tag("Test create")
    public void create(String name, String surname, String email, String login, String password, boolean canDoJob, boolean expected) {
        boolean actual = userService.create(name, surname, email, login, password, canDoJob);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testGetById() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(-10, false),
                Arguments.of(1000, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testGetById")
    @Tag("Test getById")
    public void getById(long id, boolean expected) {
        boolean actual = false;

        User foundUser = userService.getById(id);
        if (foundUser != null) {
            actual = true;
        }

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> updateTest() {
        return Stream.of(
                Arguments.of(user, 1, true),
                Arguments.of(null, 1, false),
                Arguments.of(userForUpdate, -4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("updateTest")
    public void testUpdate(User receiveUser, long id, boolean expected) {
        boolean actual = userService.update(receiveUser, id);
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
        boolean actual = userService.delete(id);
        assertEquals(expected, actual);
    }

}
