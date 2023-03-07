package edu.sabanciuniv.sabanci07.model;

/*
        {
        "userId": 1,
        "id": 1,
        "title": "delectus aut autem",
        "completed": false
        }
 */


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TodoEntity extends TodoBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id", nullable = false)
    private Integer todoId;

    private int userId;
    private int id;
    private String title;
    private boolean completed;

}
