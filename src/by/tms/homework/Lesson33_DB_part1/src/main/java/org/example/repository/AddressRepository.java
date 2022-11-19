package org.example.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class AddressRepository {

    private static final String CREATE_ADDRESS_TABLE = """
            CREATE TABLE IF NOT EXISTS address
            (
                id bigint primary key auto_increment,
                country varchar(20),
                city varchar(20),
                street varchar(40),
                number_of_house int
            )""";

    private static final String INSERT_ADDRESS = "INSERT INTO address (country, city, street, number_of_house) VALUES (?, ?, ?, ?);";
    private static final String DELETE_ADDRESS = "DELETE FROM address WHERE city IN (?)";

    public boolean init(Connection connection) {
        boolean resultOfInitialization = false;
        try {
            Statement statement = connection.createStatement();
            resultOfInitialization = statement.execute(CREATE_ADDRESS_TABLE);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return resultOfInitialization;
    }

    public Long addNewAddress(Connection connection, String country, String city, String street, int numberOfHouse) {
        Long generatedId = null;
        try {
            PreparedStatement insertAddress = connection.prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS);
            insertAddress.setString(1, country);
            insertAddress.setString(2, city);
            insertAddress.setString(3, street);
            insertAddress.setLong(4, numberOfHouse);

            int inserted = insertAddress.executeUpdate();

            if (inserted != 0) {
                ResultSet generatedKeys = insertAddress.getGeneratedKeys();

                while (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());

        }
        return generatedId;
    }

    public boolean deleteAddress(Connection connection, String city) {
        boolean resultOfDeleting = false;
        try {
            PreparedStatement deleteAddress = connection.prepareStatement(DELETE_ADDRESS);
            deleteAddress.setString(1, city);
            int deleted = deleteAddress.executeUpdate();

            if (deleted != 0) {
                resultOfDeleting = true;
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return resultOfDeleting;
    }
}
