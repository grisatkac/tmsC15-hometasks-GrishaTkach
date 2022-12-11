package org.example.repository;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Data
@Slf4j
public class ConnectionDB {

    private String url = "jdbc:mysql://localhost:3306/university";
    private String user = "root";
    private String password = "ghblevfyysq gfhjkm}";

    public Connection connect() {
        Connection resultConnection = null;
        try(Connection connection = DriverManager.getConnection(url, user, password)) {
            resultConnection = connection;
            return resultConnection;
        } catch (SQLException e) {
            System.out.println("connection error");
        }

        return resultConnection;
    }



}
