package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lei
 * @since 2018/1/31
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloGet(HttpServletRequest request, HttpServletResponse response){
        return "hello";
    }
}
