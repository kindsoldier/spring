/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public Response<Hello> hello() {
        Response<Hello> response = new Response<Hello>();
        response.setResult(new Hello());
        return response;
    }
}

