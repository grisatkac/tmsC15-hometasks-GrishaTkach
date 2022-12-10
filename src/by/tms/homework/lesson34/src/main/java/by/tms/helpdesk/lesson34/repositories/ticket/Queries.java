package by.tms.helpdesk.lesson34.repositories.ticket;

public class Queries {

    public static String add() {
        return "INSERT INTO ticket\n" +
                "(title, description, status) \n" +
                "VALUES (?, ?, ?);";
    }

    public static String find() {
        return "SELECT *\n" +
                "FROM ticket\n" +
                "WHERE id = ?;";
    }

    public static String findAll() {
        return "SELECT *\n" +
                "FROM ticket;";
    }

    public static String findByStatus() {
        return "SELECT ticket.id, ticket.title, ticket.description, ticket.status\n" +
                "                FROM user\n" +
                "                JOIN user_ticket on user.id = user_ticket.user_id\n" +
                "                JOIN ticket on user_ticket.ticket_id = ticket.id\n" +
                "                WHERE user.id = ? AND status = ?;";

        /*return "SELECT ticket.id, ticket.title, ticket.description, ticket.status\n" +
                "FROM user\n" +
                "JOIN user_ticket on user.id = user_ticket.user_id\n" +
                "JOIN ticket on user_ticket.ticket_id = ticket.i*/
    }

    public static String update() {
        return "UPDATE ticket\n" +
                "SET title = ?,\n" +
                "    description = ?,\n" +
                "    status = ?\n" +
                "where id = ?;";
    }

    public static String delete() {
        return "DELETE FROM ticket\n" +
                "WHERE ticket.id = ?;";
    }
}
