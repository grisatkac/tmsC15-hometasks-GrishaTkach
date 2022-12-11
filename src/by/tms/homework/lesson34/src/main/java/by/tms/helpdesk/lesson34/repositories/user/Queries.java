package by.tms.helpdesk.lesson34.repositories.user;

public class Queries {

    public static String create() {
        return "INSERT INTO user (first_name, last_name, email, password, can_do_job, role_id) VALUES (?,?,?,?,?,?);";
    }

    public static String findById() {
        return "SELECT user.id, first_name, last_name, email, password, can_do_job, role, role.id, ticket.id, title, description, status\n" +
                "from user\n" +
                "LEFT JOIN user_ticket ON user.id = user_ticket.user_id\n" +
                "LEFT JOIN ticket ON ticket.id = user_ticket.ticket_id\n" +
                "LEFT JOIN role ON user.role_id = role.id\n" +
                "WHERE user.id = ?;" /*"SELECT * FROM user WHERE ID = ?"*/;
    }

    public static String findByEmail() {
        return "SELECT user.id, first_name, last_name, email, password, can_do_job, role.id, role.role as role\n" +
                "FROM user\n" +
                "JOIN role ON user.role_id = role.id\n" +
                "WHERE email = ?;";
    }

    public static String findAll() {
        //return "SELECT * FROM user";
        return "SELECT user.id, first_name, last_name, email, password, can_do_job, role.id, role.role AS role\n" +
                "FROM user\n" +
                "JOIN role ON user.role_id = role.id;";
    }

    public static String update() {
        return "UPDATE user\n" +
                "SET first_name = ?,\n" +
                "    last_name = ?,\n" +
                "    email = ?,\n" +
                "    password = ?,\n" +
                "    can_do_job = ?\n" +
                "where id = ?;";
    }

    public static String delete() {
        return "DELETE FROM user\n" +
                "WHERE id = ?;";
    }
}
