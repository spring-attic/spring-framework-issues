package org.springframework.issues;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Greg Potter
 * @since 10/17/17
 */
class IntegerRowMapper implements RowMapper<Integer> {
    @Override
    public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt(1);
    }
}
