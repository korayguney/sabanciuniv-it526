package edu.sabanciuniv.sabanci05.controller;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.dto.BookResponse;
import edu.sabanciuniv.sabanci05.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{orderId}/books")
    public Set<Book> getAllBooksOfOrder(@PathVariable String orderId) {
        return orderService.getAllBooksOfOrder(orderId);
    }

    @GetMapping("/orders/{orderId}/bookdtos")
    public List<BookResponse> getAllBookDTOsOfOrder(@PathVariable String orderId) {
        return orderService.getAllBookDTOsOfOrder(orderId);
    }


}
