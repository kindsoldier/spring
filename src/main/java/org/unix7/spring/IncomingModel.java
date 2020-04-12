/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IncomingModel {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IncomingModel(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Incoming> list() {
        String queryString =
                "SELECT incomings.id as id, " +
                        "incomings.agentId as agentId, " +
                        "agents.name as agentName, " +
                        "divisions.id as divisionId, " +
                        "divisions.Name as divisionName, " +
                        "value as value " +
                "FROM incomings, agents, divisions " +
                "WHERE incomings.agentId = agents.id " +
                    "AND agents.divisionId = divisions.id" +
                "ORDER BY agentName";
        List<Incoming> incomings = jdbcTemplate.query(queryString, new IncomingMapper());
        return incomings;
    }

}
