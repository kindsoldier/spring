/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import com.fasterxml.jackson.annotation.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import java.util.HashSet;
//import java.util.Set;

public class User {
    private int id;
    public String password;
    public String username;

    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public  void  setPassword(String password){
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public User() {
    }
}


