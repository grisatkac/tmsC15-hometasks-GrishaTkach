package by.tms.tkach.lesson39.task1.repositories.role;

public class Queries {

    public static String findByRoleName() {
        return "SELECT *\n" +
                "FROM role\n" +
                "WHERE role = ?;";
    }
}
