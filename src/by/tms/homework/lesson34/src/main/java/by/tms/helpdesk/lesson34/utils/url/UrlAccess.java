package by.tms.helpdesk.lesson34.utils.url;

import by.tms.helpdesk.lesson34.entities.role.RoleValues;

import java.util.*;

public class UrlAccess {

    private static Map<String, List<String>> urlForRoles = new HashMap<>();
    private static List<String> publicURL;

    static {
        publicURL = new ArrayList<>();
        publicURL.add("/login");
        publicURL.add("/registration");

        List<String> urls = new ArrayList<>();

        urls.add("/users");
        urls.add("/tickets");
        urls.add("/home");
        urls.add("/tickets/pending");
        urls.add("/tickets/inProgress");
        urls.add("/tickets/completed");
        urls.add("/tickets/all");

        urlForRoles.put(RoleValues.USER.getValue(), urls);

        urls.add("/admin");
        urlForRoles.put(RoleValues.ADMIN.getValue(), urls);
    }

    public static boolean validateRoleForUrl(String url, String role) {
        if (role == null) {
            return publicURL.contains(url);
        }

        Set<Map.Entry<String, List<String>>> entries = urlForRoles.entrySet();
        return entries.stream()
                .filter(e -> e.getKey().equals(role))
                .anyMatch(e -> e.getValue().contains(url));
    }
}
