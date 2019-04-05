package com.example.booksapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

//    @GetMapping("/login")
//    public String login() { return "login"; }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "login";
    }

}
