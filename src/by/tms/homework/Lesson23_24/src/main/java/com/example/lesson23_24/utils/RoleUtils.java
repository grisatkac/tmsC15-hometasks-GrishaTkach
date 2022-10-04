package com.example.lesson23_24.utils;

import java.util.*;

public final class RoleUtils {
    public static final String TEACHER_ROLE = "TEACHER";
    public static final String STUDENT_ROLE = "STUDENT";
    public static final Map<String, List<String>> urlForRoles = new HashMap<>();
    public static final List<String> publicUrls = new ArrayList<>();

    static {
        initUrlForRoles();
    }

    public RoleUtils() {}

    private static void initUrlForRoles() {
        publicUrls.add("/login");
        publicUrls.add("/registration");
        urlForRoles.put(TEACHER_ROLE, List.of("/app/userInfo", "/app/students"));
        urlForRoles.put(STUDENT_ROLE, List.of("/app/userInfo", "/app/courseForm", "/app/uploadFile"));
    }

    public static boolean validateRoleForUrl(String url, String role) {
        if (publicUrls.contains(url)) {
            return true;
        }
        Set<Map.Entry<String, List<String>>> entries = urlForRoles.entrySet();
        return entries.stream()
                .filter(e -> e.getKey().equals(role))
                .anyMatch(e -> e.getValue().contains(url));
    }
}
