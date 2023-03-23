package com.students.sabancistudentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "The age cannot be less than 0")
    @Max(value = 120, message = "The age cannot be greater than 120")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int age;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    private String email;


}
