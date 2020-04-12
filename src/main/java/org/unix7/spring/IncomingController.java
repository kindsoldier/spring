/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incoming")
public class IncomingController {

    @Autowired
    private IncomingModel incomingModel;

    @GetMapping("/list")
    public Response<List<Incoming>> list() {
        Response<List<Incoming>> response = new Response<List<Incoming>>();
        List<Incoming> incomings = incomingModel.list();
        response.setResult(incomings);
        return response;
    }

}
