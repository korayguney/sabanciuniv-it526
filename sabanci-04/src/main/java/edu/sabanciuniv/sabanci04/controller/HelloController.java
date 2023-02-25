package edu.sabanciuniv.sabanci04.controller;

import edu.sabanciuniv.sabanci04.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    List<Student> students = new ArrayList<>();

    // Service & End-point & API
    // http://localhost:8080/hello?name=Koray  --> Request Parameters
    // http://localhost:8080/hello?name=Ayşe&age=30 --> Request Parameters
    // http://localhost:8080/hello/30?name=Ayşe --> Path Variable
    @RequestMapping(value = "/hello/{age}/{city}", method = RequestMethod.GET)
    public StringResponse sayHello(@RequestParam(required = false, defaultValue = "Mustafa") String name,
                                   @PathVariable int age,
                                   @PathVariable String city) {
        return new StringResponse("Hello " + name + " from " + city + ", age : " + age);
    }

    // http://localhost:8080/calculate/sum?num1=10&num2=20
    // output --> 10 + 20 = 30
    @RequestMapping(value = "/calculate/{operation}", method = RequestMethod.GET)
    public String calculate(@PathVariable String operation,
                            @RequestParam(defaultValue = "1000") int num1,
                            @RequestParam(required = false) int num2) {

        if (operation.equals("sum")) {
            return String.format("%d + %d = %d", num1, num2, (num1 + num2));
        } else if (operation.equals("substract")) {
            return num1 + " - " + num2 + " = " + (num1 - num2);
        } else if (operation.equals("multiply")) {
            return num1 + " * " + num2 + " = " + (num1 * num2);
        } else if (operation.equals("devide")) {
            return num1 + " / " + num2 + " = " + (num1 / num2);
        }
        return "Something went wrong!";

        // return switch (operation) {
        //     case "sum" -> num1 + " + " + num2 + " = " + (num1 + num2);
        //     case "substract" -> num1 + " - " + num2 + " = " + (num1 - num2);
        //     case "multiply" -> num1 + " * " + num2 + " = " + (num1 * num2);
        //     case "devide" -> num1 + " / " + num2 + " = " + (num1 / num2);
        //     default -> "Something went wrong!";
        // };
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudentList() {
        students.add(new Student("Ali Veli", 18, 'm', 4325));
        students.add(new Student("Hasan Kaya", 19, 'm', 4342));
        students.add(new Student("Ayşe Türk", 21, 'f', 5464));
        return students;
    }

    @PostMapping("/students")
    public List<Student> putNewStudentToStudentList(@RequestBody Student newStudent) {
        this.students.add(newStudent);
        return this.students;
    }

}
