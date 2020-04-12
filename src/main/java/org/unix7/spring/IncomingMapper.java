/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncomingMapper  implements RowMapper<Incoming> {

    public Incoming mapRow(ResultSet rs, int rowNum) throws SQLException {
        Incoming incoming = new Incoming();

        incoming.setId(rs.getInt("id"));

        incoming.setAgentId(rs.getInt("agentId"));
        incoming.setAgentName(rs.getString("agentName"));

        incoming.setDivisionId(rs.getInt("divisionId"));
        incoming.setDivisionName(rs.getString("divisionName"));

        incoming.setValue(rs.getInt("value"));

        return incoming;
    }
}
