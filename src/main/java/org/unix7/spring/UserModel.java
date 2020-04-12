/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserModel {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserModel(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> list() {
        String queryString = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(queryString, new UserMapper());
        return users;
    }

    public List<User> list(int limit, int offset) {
        String queryString = "SELECT * FROM users LIMIT $1 OFFSET $2";
        List<User> users = jdbcTemplate.query(
                queryString,
                new Object[]{ limit, offset },
                new UserMapper()
        );
        return users;
    }

    public void create(User user) {
        String queryString = "INSERT INTO users(username, password) VALUES ($1, $2)";
        jdbcTemplate.update(queryString, new Object[]{ user.getUsername(), user.getPassword() });
    }

    public void update(int id, User user) {
        String queryString = "UPDATE users(username, password) SET ($1, $2) WHERE id = $3";
        jdbcTemplate.update(queryString, new Object[]{ user.getUsername(), user.getPassword(), id });
    }

    public User get(int id) {
        String queryString = "SELECT * FROM users WHERE id = $1";
        User user = jdbcTemplate.queryForObject(queryString, new Object[]{ id }, new UserMapper());
        return user;
    }

    public void delete(int id) {
        String queryString = "DELETE FROM users WHERE id = $1";
        jdbcTemplate.update(queryString, new Object[]{ id });
    }

}
