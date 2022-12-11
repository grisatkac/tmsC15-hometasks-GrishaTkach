package by.tms.helpdesk.lesson34.repositories.role;

public class Queries {

    public static String findByRoleName() {
        return "SELECT *\n" +
                "FROM role\n" +
                "WHERE role = ?;";
    }
}
