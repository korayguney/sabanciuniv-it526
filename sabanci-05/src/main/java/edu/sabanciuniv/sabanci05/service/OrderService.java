package edu.sabanciuniv.sabanci05.service;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.Order;
import edu.sabanciuniv.sabanci05.model.dto.BookDTO;
import edu.sabanciuniv.sabanci05.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Set<Book> getAllBooksOfOrder(String orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId);
        return order.getBookList();
    }

    public List<BookDTO> getAllBookDTOsOfOrder(String orderId) {
        Order order = orderRepository.findOrderByOrderId(orderId);
        List<BookDTO> bookDTOList = new ArrayList<>();
        // mapping
        // mapstruct, dozer API, jmapper
        for (Book book : order.getBookList()) {
            BookDTO bookDTO = BookDTO.builder()
                    .bookName(book.getBookName())
                    .price(book.getPrice())
                    .build();
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
}
