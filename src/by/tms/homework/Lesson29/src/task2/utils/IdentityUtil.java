package task2.utils;

public class IdentityUtil {
    private static long userId = 1L;

    public IdentityUtil() {}

    public static long generateUserId() {
        return userId++;
    }
}

