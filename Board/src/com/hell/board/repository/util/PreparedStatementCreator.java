package com.hell.board.repository.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mingook on 2016년8월 9일 (화).
 */
public interface PreparedStatementCreator {
    PreparedStatement createPreparedStatement(Connection connection) throws SQLException;
}
