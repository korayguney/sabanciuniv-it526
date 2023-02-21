package edu.sabanciuniv.sabanci04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Service & End-point & API
    // http://localhost:8080/hello?name=Koray
    // http://localhost:8080/hello?name=Ayşe&age=30
    @RequestMapping("/hello")
    public String sayHello(@RequestParam String name, @RequestParam int age){
        return "Hello " + name + ", age : " + age;
    }

}
