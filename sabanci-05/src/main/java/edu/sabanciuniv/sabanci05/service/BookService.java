package edu.sabanciuniv.sabanci05.service;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addNewBook(Book book) {
        if (book.getAuthor().length() > 100) {
            throw new IllegalArgumentException("The author name length cannot be greater than 100 characters!");
        }
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateExistingBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteExistingBook(Book book) {
        bookRepository.delete(book);
    }
}
