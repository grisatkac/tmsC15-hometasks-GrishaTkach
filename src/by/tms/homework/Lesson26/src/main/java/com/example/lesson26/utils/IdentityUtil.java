package com.example.lesson26.utils;

public class IdentityUtil {

    private static long USER_ID = 1L;

    private IdentityUtil() {}

    public static long generateUserId() {
        return USER_ID++;
    }
}
