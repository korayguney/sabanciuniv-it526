package com.students.sabancistudentservice.controller;

import com.students.sabancistudentservice.entity.Student;
import com.students.sabancistudentservice.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repository;

    @GetMapping("/")
    public String showStudentListIndex(Model theModel) {
        theModel.addAttribute("students", repository.findAll());
        return "index";
    }

    @GetMapping("/index")
    public String showStudentList(Model theModel) {
        theModel.addAttribute("students", repository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignupPage(Student student) {
        return "addstudent";
    }

    @PostMapping("/addstudent")
    public String addStudent(@Valid Student student, BindingResult result, Model theModel) {
        if (result.hasErrors()) {
            return "addstudent";
        }

        repository.save(student);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdatePage(@PathVariable int id, Model theModel) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
        theModel.addAttribute("student", student);
        return "updatestudent";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @Valid Student student, BindingResult result, Model theModel) {
        if (result.hasErrors()) {
            return "updatestudent";
        }

        repository.save(student);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student : " + id));
        repository.delete(student);

        return "redirect:/index";
    }

}
