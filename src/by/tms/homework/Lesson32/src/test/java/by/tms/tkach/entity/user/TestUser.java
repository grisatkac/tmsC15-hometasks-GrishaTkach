package by.tms.tkach.entity.user;

import by.tms.tkach.entities.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {

    static User user1;
    static User user2;

    @BeforeAll
    public static void init() {
        user1 = User.builder()
                .name("newName").surname("newSurname").email("newEmail").login("newLogin").password("newPassword").canDoJob(true)
                .build();
        user2 = User.builder()
                .name("newName").surname("newSurname").email("newEmail").login("newLogin").password("newPassword").canDoJob(true)
                .build();
    }

    @Test
    @Tag("Test CanDoWork")
    public void testCanDoWork() {
        boolean expected = true;
        assertEquals(expected, user2.canDoWork());
    }

    @Test
    @Tag("Test MakeUserCanDoJob")
    public void testMakeUserCanDoJob() {
        boolean expected = true;
        user1.makeUserCanDoJob();
        assertEquals(expected, user1.canDoWork());
    }

    @Test
    @Tag("Test MakeUserNotCanDoJob")
    public void testMakeUserNotCanDoJob() {
        boolean expected = false;
        user1.makeUserNotCanDoJob();
        assertEquals(expected, user1.canDoWork());
    }

    @Test
    @Tag("Test clone")
    public void testClone() throws CloneNotSupportedException {
        boolean expected = true;
        User clonedUser = user1.clone();
        assertEquals(expected, clonedUser.equals(user1));
    }
}
