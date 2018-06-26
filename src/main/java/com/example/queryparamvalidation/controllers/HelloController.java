package com.example.queryparamvalidation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/user")
    public String greeting(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone){
        System.out.println("Name: "+name+"\nemail: "+email+"\nphone: "+phone);
        return "Name: "+name+"\nemail: "+email+"\nphone: "+phone;

    }
}
