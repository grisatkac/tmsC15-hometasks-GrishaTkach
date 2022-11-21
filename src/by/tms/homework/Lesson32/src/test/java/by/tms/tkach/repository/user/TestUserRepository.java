package by.tms.tkach.repository.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.repositories.user.UserRepository;
import by.tms.tkach.repositories.user.UserRepositoryImpl;
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

public class TestUserRepository {

    static UserRepositoryImpl userRepository;
    static User user;

    @BeforeAll
    public static void init() {
        userRepository = new UserRepositoryImpl();
        user = User.builder()
                .name("name")
                .surname("surname")
                .email("user@gmail.com")
                .login("login")
                .password("password")
                .canDoJob(true)
                .build();
    }

    public static Stream<Arguments> testAdd() {
        return Stream.of(
                Arguments.of(user, true),
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

    public static Stream<Arguments> testFind() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(-10, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testFind")
    @Tag("Test find user by id")
    public void findTest(long id, boolean expected) {
        boolean actual = false;
        User foundUser = userRepository.find(id);

        if (foundUser != null) {
            actual = id == foundUser.getId();
        }

        assertEquals(expected, actual);
    }

    @Test
    @Tag("Test find all users")
    public void findAllTest() {
        boolean expected = true;
        List<User> userList = userRepository.findAll();
        List<User> newList = new ArrayList<>(userRepository.getRepository().values());
        boolean actual = userList.equals(newList);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testUpdate() {
        return Stream.of(
                Arguments.of(user, 1, true),
                Arguments.of(null, 1, false),
                Arguments.of(user, -4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testUpdate")
    public void update(User user, long id, boolean expected) {
        boolean actual = userRepository.update(user, id);
        if (actual) {
            actual = userRepository.find(id).equals(user);
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
    public void delete(long id, boolean expected) {
        User foundUser = null;
        boolean actual = false;

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
}
