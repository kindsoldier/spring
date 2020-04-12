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

    public List<User> list(Long limit, Long offset) {
        String queryString = "SELECT * FROM users LIMIT ? OFFSET ?";
        List<User> users = jdbcTemplate.query(
                queryString,
                new Object[]{ limit, offset },
                new UserMapper()
        );
        return users;
    }

    public void create(User user) {
        String queryString = "INSERT INTO users(username, password) VALUES (?, ?)";
        jdbcTemplate.update(queryString, new Object[]{ user.getUsername(), user.getPassword() });
    }

    public void update(Long id, User user) {
        String queryString = "UPDATE users(username, password) SET (?, ?) WHERE id = ?";
        jdbcTemplate.update(queryString, new Object[]{ user.getUsername(), user.getPassword(), id });
    }

    public User get(Long id) {
        String queryString = "SELECT * FROM users WHERE id = ?";
        User user = jdbcTemplate.queryForObject(queryString, new Object[]{ id }, new UserMapper());
        return user;
    }

    public void delete(Long id) {
        String queryString = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(queryString, new Object[]{ id });
    }

}
