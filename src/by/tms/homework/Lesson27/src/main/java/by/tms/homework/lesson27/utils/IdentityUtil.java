package by.tms.homework.lesson27.utils;

public class IdentityUtil {

    public static long INITIAL_IDENTITY_VALUE = 1l;

    private IdentityUtil() {}

    public static long getId() {
        return INITIAL_IDENTITY_VALUE++;
    }
}
