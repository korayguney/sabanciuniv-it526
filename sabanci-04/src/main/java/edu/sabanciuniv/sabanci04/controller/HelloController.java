package edu.sabanciuniv.sabanci04.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    // Service & End-point & API
    // http://localhost:8080/hello?name=Koray  --> Request Parameters
    // http://localhost:8080/hello?name=Ayşe&age=30 --> Request Parameters
    // http://localhost:8080/hello/30?name=Ayşe --> Path Variable
    @RequestMapping(value = "/hello/{age}/{city}", method = RequestMethod.GET)
    public StringResponse sayHello(@RequestParam(required = false, defaultValue = "Mustafa") String name,
                           @PathVariable int age,
                           @PathVariable String city){
        return new StringResponse("Hello " + name + " from " + city + ", age : " + age);
    }

    // http://localhost:8080/sum?num1=10&num2=20
    // output --> 10 + 20 = 30
    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public String calculate(@RequestParam(required = false) int num1,
                            @RequestParam(required = false) int num2){
        return String.valueOf(num1 + num2);
    }

}
