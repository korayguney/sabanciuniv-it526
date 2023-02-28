package edu.sabanciuniv.sabanci05.initilize;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.Order;
import edu.sabanciuniv.sabanci05.repository.BookRepository;
import edu.sabanciuniv.sabanci05.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;

@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (orderRepository.count() == 0) {
            Book book1 = new Book("book1", "author1", 100.5);
            Book book2 = new Book("book2", "author2", 20.5);
            Book book3 = new Book("book3", "author3", 300.5);

            Order order1 = new Order("aaaa", LocalDateTime.of(2022, Month.DECEMBER, 1, 23, 01));
            Order order2 = new Order("bbbb", LocalDateTime.of(2022, Month.AUGUST, 1, 21, 01));

            book1.setOrder(order1);
            book2.setOrder(order2);
            book3.setOrder(order2);
            book3.setOrder(order1);

            orderRepository.save(order1);
            orderRepository.save(order2);

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
        }
    }
}
