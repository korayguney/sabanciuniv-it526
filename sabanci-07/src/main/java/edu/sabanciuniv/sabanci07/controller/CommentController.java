package edu.sabanciuniv.sabanci07.controller;

import edu.sabanciuniv.sabanci07.model.CommentEntity;
import edu.sabanciuniv.sabanci07.model.TodoEntity;
import edu.sabanciuniv.sabanci07.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final RestTemplate restTemplate;

    public CommentController(CommentRepository commentRepository, RestTemplate restTemplate) {
        this.commentRepository = commentRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/comment/{id}")
    public CommentEntity getJsonFromRemoteTodoList(@PathVariable int id) {
        System.out.println("Test");
        CommentEntity comment = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments/" + id, CommentEntity.class);
        commentRepository.save(comment);
        return comment;
    }
}
