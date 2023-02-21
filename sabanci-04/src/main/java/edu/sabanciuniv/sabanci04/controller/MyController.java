package edu.sabanciuniv.sabanci04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

   //server.port=9090

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public MyResponse calculate(@RequestParam int num1, @RequestParam int num2) {
        int toplam = num1 + num2;
        return new MyResponse(toplam);
    }


}
