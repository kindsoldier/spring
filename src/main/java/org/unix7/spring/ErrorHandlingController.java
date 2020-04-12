/*
 * Copyright 2020 Oleg Borodin  <borodin@unix7.org>
 */

package org.unix7.spring;

import org.springframework.http.HttpStatus;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ErrorHandlingController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ModelAndView handleError() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Error");
        mav.setViewName("index");
        return mav;
    }
}