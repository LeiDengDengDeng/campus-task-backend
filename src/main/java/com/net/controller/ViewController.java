package com.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by liying on 2018/12/17.
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/login")
    public String getLogin(HttpSession session) {
        return "login";
    }

    @RequestMapping(value = "/signUp")
    public String getSignUp(HttpSession session) {
        return "sign-up";
    }

    @RequestMapping(value = "/index")
    public String getIndex(HttpSession session) {
        return "complain";
    }
}
