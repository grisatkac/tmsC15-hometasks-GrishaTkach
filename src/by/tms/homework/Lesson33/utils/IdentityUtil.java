package by.tms.homework.Lesson33.utils;

public class IdentityUtil {

    private static long USER_ID = 1L;

    private IdentityUtil() {}

    public static long generateUserId() {
        return USER_ID++;
    }
}
