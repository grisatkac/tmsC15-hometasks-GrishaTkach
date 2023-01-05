package org.example.singleton;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {
        Connection connection = ConnectionDBSingleton.getInstance().getConnection();
    }
}
