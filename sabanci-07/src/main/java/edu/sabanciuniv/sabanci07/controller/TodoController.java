package edu.sabanciuniv.sabanci07.controller;

import edu.sabanciuniv.sabanci07.model.TodoEntity;
import edu.sabanciuniv.sabanci07.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class TodoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/todo/{id}")
    public TodoEntity getJsonFromRemoteTodoList(@PathVariable int id) {
        System.out.println("Test");
        TodoEntity todo = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/" + id, TodoEntity.class);
        todo.setQueriedDate(LocalDateTime.now());
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping("/todo/second/{id}")
    public TodoEntity getTodoFromDatabase(@PathVariable int id) {
        TodoEntity todo =  todoRepository.getTodoEntityByTodoId(id);
        return todo;
    }

}
