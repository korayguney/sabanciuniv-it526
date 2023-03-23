package com.students.sabancistudentservice.util;

import com.students.sabancistudentservice.entity.Student;
import com.students.sabancistudentservice.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
       repository.deleteAll();

       repository.save(Student.builder().name("Ali").age(23).email("a@a.com").build());
       repository.save(Student.builder().age(35).name("Hasan").email("ha@ah.com").build());
       repository.save(Student.builder().age(56).name("Ahmet").email("ahmet@ah.com").build());
       repository.save(Student.builder().age(22).name("Ayşe").email("ayse@a.com").build());

       repository.findAll().forEach(student -> logger.info("{}", student));

    }
}
