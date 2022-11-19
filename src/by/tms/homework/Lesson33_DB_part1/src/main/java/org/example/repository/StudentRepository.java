package org.example.repository;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Data
@Slf4j
public class StudentRepository {

    private static final String CREATE_USERS_TABLE = """
                CREATE TABLE IF NOT EXISTS student
                (
                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                    first_name VARCHAR(20),
                    last_name VARCHAR(20),
                    address_id BIGINT,
                    FOREIGN KEY fk_address(address_id) 
                        REFERENCES address(id)
                        ON DELETE SET NULL
                )""";

    private static final String INSERT_USER = "INSERT INTO student (first_name, last_name, address_id) VALUES (?,?,?);";
    private static final String DELETE_ADDRESS = "DELETE FROM student WHERE id IN (?)";

    public boolean init(Connection connection) {
        boolean resultOfInitialization = false;
        try {
            Statement statement = connection.createStatement();
            resultOfInitialization = statement.execute(CREATE_USERS_TABLE);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return resultOfInitialization;
    }

    public Long addNewStudent(Connection connection, String firstName, String lastName, Long addressId) {
        Long generatedId = null;
        try {
            PreparedStatement insertUser = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            insertUser.setString(1, firstName);
            insertUser.setString(2, lastName);
            insertUser.setLong(3, addressId);

            int inserted = insertUser.executeUpdate();

            if (inserted != 0) {
                ResultSet generatedKeys = insertUser.getGeneratedKeys();

                while (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return generatedId;
    }

    public boolean deleteStudent(Connection connection, Long id) {
        boolean resultOfDeleting = false;
        try {
            PreparedStatement deleteAddress = connection.prepareStatement(DELETE_ADDRESS);
            deleteAddress.setLong(1, id);
            int deleted = deleteAddress.executeUpdate();

            if (deleted != 0) {
                resultOfDeleting = true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return resultOfDeleting;
    }

    public void getAllInformationAboutStudents(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT student.first_name, student.last_name, address.country, address.city, address.street, address.number_of_house FROM student\n" +
                    "JOIN university.address ON student.address_id = address.id");
            while (resultSet.next()) {
                log.info("first_name: " + resultSet.getString("first_name"));
                log.info("last_name: " + resultSet.getString("last_name"));
                log.info("country: " + resultSet.getString("country"));
                log.info("city: " + resultSet.getString("city"));
                log.info("street: " + resultSet.getString("street"));
                log.info("number of house: " + resultSet.getInt("number_of_house"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
