package by.tms.tkach.lesson39.task2.repository;

public class Query {

    public static String addTask() {
        return "INSERT INTO task\n" +
                "(title, description, status) \n" +
                "VALUES (?, ?, ?);";
    }

    public static String updateStatusTask() {
        return "UPDATE task\n" +
                "SET status= ?\n" +
                "WHERE title = ? AND description = ?;";
    }

    public static String deleteTask() {
        return "DELETE FROM task\n" +
                "WHERE title = ? AND description = ? AND status = ?;";
    }
}
