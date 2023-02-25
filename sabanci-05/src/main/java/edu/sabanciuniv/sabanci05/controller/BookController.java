package edu.sabanciuniv.sabanci05.controller;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    // Dependency Injection
    // IoC --> Inversion of Controller
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    @PutMapping("/books")
    public Book updateExistingBook(@RequestBody Book book){
        return bookService.updateExistingBook(book);
    }

    @DeleteMapping("/books")
    public void deleteExistingBook(@RequestBody Book book){
        bookService.deleteExistingBook(book);
    }
}
