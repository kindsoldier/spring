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

//    public List<Incoming> list() {
//        String queryString =
//                "SELECT incomings.id as id, " +
//                        "incomings.agentId as agentId, " +
//                        "agents.name as agentName, " +
//                        "divisions.id as divisionId, " +
//                        "divisions.Name as divisionName, " +
//                        "value as value " +
//                "FROM incomings, agents, divisions " +
//                "WHERE incomings.agentId = agents.id " +
//                    "AND agents.divisionId = divisions.id " +
//                "ORDER BY agentName";
//        List<Incoming> incomings = jdbcTemplate.query(queryString, new IncomingMapper());
//        return incomings;
//    }

    public static class ListResponse<T> {

    }

    public ListResult<List<Incoming>> list(int limit, int offset, String pattern) {
        String selectQuery =
                "SELECT incomings.id as id, " +
                        "incomings.agentId as agentId, " +
                        "agents.name as agentName, " +
                        "divisions.id as divisionId, " +
                        "divisions.Name as divisionName, " +
                        "value as value " +
                "FROM incomings, agents, divisions " +
                "WHERE incomings.agentId = agents.id " +
                "AND agents.divisionId = divisions.id " +
                "AND agents.name LIKE $1 " +
                "ORDER BY agentName " +
                "LIMIT $2 OFFSET $3";
        String like = "%" + pattern + "%";
        List<Incoming> incomings = jdbcTemplate.query(
                                        selectQuery,
                                        new Object[]{ like, limit, offset },
                                        new IncomingMapper()
        );
        String totalQuery = "SELECT COUNT(*) " +
                "FROM incomings, agents, divisions " +
                "WHERE incomings.agentId = agents.id " +
                    "AND agents.divisionId = divisions.id " +
                    "AND agents.name LIKE $1";
        int total = jdbcTemplate.queryForObject(
                                        totalQuery,
                                        new Object[]{ like },
                                        Integer.class);

        ListResult<List<Incoming>> result = new ListResult<List<Incoming>>();
        result.setList(incomings);
        result.setLimit(limit);
        result.setOffset(offset);
        result.setTotal(total);
//        result.setPatern(total);
        return result;
    }


}
