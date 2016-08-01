package com.hell.board.repository.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public abstract class QueryExecutor {
    public void execute() {
        Connection conn = ConnectionManager.getInstance().createConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = query(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.getInstance().closeConnection(conn, pstmt);
        }
    }

    protected abstract PreparedStatement query(Connection connection) throws SQLException;
}
