package by.tms.tkach.lesson38.task2.utils;

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
