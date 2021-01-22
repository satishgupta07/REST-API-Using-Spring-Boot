package com.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/welcome")
    public String welocome() {
        String text = "This is private page, ";
               text += "this page is not allowed to unauthenticated users";

         return text;
    }

    @RequestMapping("/getusers")
    public String getUser() {
        return "{\"name\":\"Satish\"}";
    }
}
