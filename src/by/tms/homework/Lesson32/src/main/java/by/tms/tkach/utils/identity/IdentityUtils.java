package by.tms.tkach.utils.identity;

import lombok.ToString;

@ToString
public class IdentityUtils {

    public static long userId = 1L;

    public IdentityUtils() {}

    public static long generateUserId() {
        return userId++;
    }

    public static void decrementUserIdCount() {
        userId--;
    }
}
