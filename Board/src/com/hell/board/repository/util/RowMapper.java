package com.hell.board.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mingook on 2016년8월 9일 (화).
 */
public interface RowMapper<T> {
    T row(ResultSet rs) throws SQLException;
}
