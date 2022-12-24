package by.tms.tkach.lesson39.task1.services.identity;

import lombok.ToString;

@ToString
public class IdentityUtils {

    public static Long id = 1L;

    public IdentityUtils() {}

    public static long generateId() {
        return id++;
    }

    public static void decrementIdCount() {
        id--;
    }
}
