package com.hell.board.repository.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingook on 2016년8월 9일 (화).
 */
public class JdbcExecutor {
    public static int update(PreparedStatementCreator creator, Object... params) {
        Connection connection = DataSource.getInstance().createConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            pstmt = creator.createPreparedStatement(connection);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DataSource.getInstance().closeConnection(connection, pstmt);
        return result;
    }

    public static <T> List<T> query(PreparedStatementCreator creator, RowMapper<T> rowMapper) {
        Connection connection = DataSource.getInstance().createConnection();
        PreparedStatement ps = null;
        List<T> rows = new ArrayList<T>();

        try {
            ps = creator.createPreparedStatement(connection);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rows.add(rowMapper.row(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public static <T> T queryForObject(PreparedStatementCreator creator, RowMapper<T> rowMapper, Object... params) {
        Connection connection = DataSource.getInstance().createConnection();
        PreparedStatement pstmt = null;
        T object = null;

        try {
            pstmt = creator.createPreparedStatement(connection);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                object = rowMapper.row(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DataSource.getInstance().closeConnection(connection, pstmt);
        return object;
    }
}
