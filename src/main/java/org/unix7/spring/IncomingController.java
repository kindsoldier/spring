/*
 *
 *  * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 *
 *
 */

package org.unix7.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incoming")
public class IncomingController {

    @Autowired
    private IncomingModel incomingModel;

    public static class ListRequest {
        private int offset;
        private int limit;
        private String pattern;


        public int getOffset() {
            return offset;
        }
        public void setOffset(int offset) {
            this.offset = offset;
        }
        public int getLimit() {
            return limit;
        }
        public void setLimit(int limit) {
            this.limit = limit;
        }
        public String getPattern() {
            return pattern;
        }
        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

    }

    @PostMapping("/list")
    public Response<ListResult<List<Incoming>>> list(@RequestBody ListRequest listRequest) {
        Response<ListResult<List<Incoming>>> response = new Response<ListResult<List<Incoming>>>();
        ListResult<List<Incoming>> result = incomingModel.list(
                                                listRequest.getLimit(),
                                                listRequest.getOffset(),
                                                listRequest.getPattern()
        );
        response.setResult(result);
        return response;
    }

}
