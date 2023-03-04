package edu.sabanciuniv.sabanci05.service;

import edu.sabanciuniv.sabanci05.exception.UnauthorizedException;
import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.dto.BookRequest;
import edu.sabanciuniv.sabanci05.model.dto.BookResponse;
import edu.sabanciuniv.sabanci05.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponse addNewBook(BookRequest bookRequest) {
        if (bookRequest.getAuthor().length() > 100) {
            throw new IllegalArgumentException("The author name length cannot be greater than 100 characters!");
        }

        if (!bookRequest.getAccessToken().equals("12345678")) {
            throw new UnauthorizedException("Your access token is invalid : " + bookRequest.getAccessToken());
        }

        // DTO to Entity mapper
        Book bookEntity = Book.builder()
                .bookName(bookRequest.getBookName())
                .author(bookRequest.getAuthor())
                .price(bookRequest.getPrice())
                .build();

        bookEntity = bookRepository.save(bookEntity);

        // Entity to DTO mapper
        BookResponse response = BookResponse.builder()
                .bookId(bookEntity.getId())
                .bookName(bookEntity.getBookName())
                .author(bookEntity.getAuthor())
                .price(bookEntity.getPrice())
                .build();

        return response;
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
