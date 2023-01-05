package by.tms.tkach.lesson39.task1.repositories.user_ticket;

public class UserTicketQueries {

    public static String addTicket() {
        return "INSERT INTO user_ticket\n" +
                "(ticket_id)\n" +
                "VALUES (?);";
    }

    public static String deleteTicket() {
        return "DELETE\n" +
                "FROM user_ticket\n" +
                "WHERE user_ticket.ticket_id = ?;";
    }

    public static String deleteUser() {
        return "UPDATE user_ticket\n" +
                "SET user_id = NULL\n" +
                "where user_ticket.user_id = ?;";
    }
}
