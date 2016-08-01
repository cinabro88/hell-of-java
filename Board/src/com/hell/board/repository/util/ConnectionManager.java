package com.hell.board.repository.util;

import java.sql.*;

/**
 * Created by mingook on 2016년8월 1일 (월).
 */
public class ConnectionManager {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";
    private static final String DB_ID = "sa";
    private static final String DB_PASSWORD = "";

    private static ConnectionManager instance;

    private ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }

        return instance;
    }

    public Connection createConnection() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.
                    getConnection(DB_URL, DB_ID, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void closeConnection(Connection connection, Statement statement) {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {

        }
    }
}
