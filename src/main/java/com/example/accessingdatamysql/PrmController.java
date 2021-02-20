package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PrmController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}