package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lei
 * @since 2018/1/30
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginGet(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }
}
