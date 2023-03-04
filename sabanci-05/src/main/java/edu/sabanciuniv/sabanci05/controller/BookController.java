package edu.sabanciuniv.sabanci05.controller;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.dto.BookRequest;
import edu.sabanciuniv.sabanci05.model.dto.BookResponse;
import edu.sabanciuniv.sabanci05.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    // Dependency Injection
    // IoC --> Inversion of Controller
    @Autowired
    private BookService bookService;

    @Value("${developer.name}")
    private String developerName;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        log.info("Developer of the project :" + developerName);
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public ResponseEntity<BookResponse> addNewBook(@RequestBody BookRequest book) {
        return ResponseEntity.ok().body(bookService.addNewBook(book));
    }

    @PutMapping("/books")
    public Book updateExistingBook(@RequestBody Book book) {
        return bookService.updateExistingBook(book);
    }

    @DeleteMapping("/books")
    public void deleteExistingBook(@RequestBody Book book) {
        bookService.deleteExistingBook(book);
    }
}
