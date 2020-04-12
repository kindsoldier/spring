/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserModel userModel;

    public static class ListRequest {
        private int offset;
        private int limit;

        public int getOffset() {
            return offset;
        }
        public void setOffset(int id) {
            this.offset = offset;
        }
        public int getLimit() {
            return  limit;
        }
        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    @PostMapping("/list")
    public Response<List<User>> list(@RequestBody ListRequest listRequest) {
        Response<List<User>> response = new Response<List<User>>();
        List<User> users = userModel.list(listRequest.getLimit(), listRequest.getOffset());
        response.setResult(users);
        return response;
    }

    @GetMapping("/list")
    public Response<List<User>> list() {
        Response<List<User>> response = new Response<List<User>>();
        List<User> users = userModel.list();
        response.setResult(users);
        return response;
    }

    @PostMapping("/create")
    public Response<User> create(@RequestBody User user) {
        Response<User> response = new Response<User>();
        userModel.create(user);
        response.setResult(user);
        return response;
    }

    public static class GetRequest {
        private int id;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    }

    @PostMapping("/get")
    public Response<User> get(@RequestBody GetRequest getRequest) {
        Response<User> response = new Response<User>();
        User user = userModel.get(getRequest.getId());
        response.setResult(user);
        return response;
    }

    public static class DeleteRequest {
        private int id;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    }

    @PostMapping("/delete")
    public Response<Object> delete(@RequestBody DeleteRequest deleteRequest) {
        userModel.delete(deleteRequest.getId());
        return new Response<Object>();
    }

}

