package by.tms.tkach.repositories.user;

import by.tms.tkach.entities.user.User;
import by.tms.tkach.utils.log.LogUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserRepository implements Serializable {
    @Serial
    private static final long serialVersionUID = -5568938481760191887L;
    private static final Map<Long, User> USER_REPOSITORY = new HashMap<>();

    public static Map<Long, User> getUSER_REPOSITORY() {
        return USER_REPOSITORY;
    }

    static {
        generateTickets();
        LogUtil.printInfo("User repository has been created");
    }

    private static void generateTickets(){
        User user1 = User.builder()
                .name("name1")
                .surname("surname1")
                .email("user1@gmail.com")
                .login("login1")
                .password("password1")
                .canDoJob(true)
                .build();

        User user2 = User.builder()
                .name("name2")
                .surname("surname2")
                .email("user2@gmail.com")
                .login("login2")
                .password("password2")
                .canDoJob(true)
                .build();

        User user3 = User.builder()
                .name("name3")
                .surname("surname3")
                .email("user3@gmail.com")
                .login("login3")
                .password("password3")
                .canDoJob(true)
                .build();

        USER_REPOSITORY.put(user1.getId(), user1);
        USER_REPOSITORY.put(user2.getId(), user2);
        USER_REPOSITORY.put(user3.getId(), user3);
    }
}
