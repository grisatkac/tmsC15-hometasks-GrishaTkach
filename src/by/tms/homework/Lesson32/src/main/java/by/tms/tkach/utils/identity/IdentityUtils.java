package by.tms.tkach.utils.identity;

import lombok.ToString;

@ToString
public class IdentityUtils {

    public static long user_id = 1L;

    public IdentityUtils() {}

    public static long generateUserId() {
        return user_id++;
    }

    public static void decrementUserIdCount() {
        user_id--;
    }
}
