package by.tms.helpdesk.lesson34.utils.identity;

import lombok.ToString;

@ToString
public class IdentityUtils {

    /*public static long userId = 1L;

    public IdentityUtils() {}

    public static long generateUserId() {
        return userId++;
    }

    public static void decrementUserIdCount() {
        userId--;
    }*/

    public static Long id = 1L;

    public IdentityUtils() {}

    public static long generateId() {
        return id++;
    }

    public static void decrementIdCount() {
        id--;
    }
}
