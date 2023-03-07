package edu.sabanciuniv.sabanci05.service;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.Order;
import edu.sabanciuniv.sabanci05.model.dto.BookResponse;
import edu.sabanciuniv.sabanci05.model.dto.OrderRequest;
import edu.sabanciuniv.sabanci05.model.dto.OrderResponse;
import edu.sabanciuniv.sabanci05.repository.BookRepository;
import edu.sabanciuniv.sabanci05.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public Set<Book> getAllBooksOfOrder(String orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId);
        return order.getBookList();
    }

    public List<BookResponse> getAllBookDTOsOfOrder(String orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId);
        List<BookResponse> bookDTOList = new ArrayList<>();
        // mapping
        // mapstruct, dozer API, jmapper
        for (Book book : order.getBookList()) {
            BookResponse bookDTO = BookResponse.builder()
                    .bookName(book.getBookName())
                    .price(book.getPrice())
                    .build();
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Set<Book> bookList1 = new HashSet<>();

        // for loop --> orderRequest.getBookIdList()
        //  Book --> bookRepository.findById(bookId)
        //  Set<Book> add

        // alternative-1
        Set<Book> bookList = orderRequest.getBookIdList().stream()
                .map(bookId -> bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new))
                .collect(Collectors.toSet());

        Set<Book> bookList2 = orderRequest.getBookIdList().stream()
                .map(new Function<Integer, Book>() {
                    @Override
                    public Book apply(Integer bookId) {
                        return bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
                    }
                }).collect(Collectors.toSet());


        // alternative-2
        orderRequest.getBookIdList().stream()
                .forEach((b) ->
                        bookList1.add(bookRepository.findById(b).orElseThrow(IllegalArgumentException::new))
                );

        Order order = Order.builder()
                .orderId(UUID.randomUUID())
                .orderDate(LocalDateTime.now())
                .bookList(bookList)
                .build();

        order = orderRepository.save(order);

        return new OrderResponse(order.getOrderId().toString());
    }
}
