package edu.sabanciuniv.sabanci05.controller;

import edu.sabanciuniv.sabanci05.model.Book;
import edu.sabanciuniv.sabanci05.model.dto.BookResponse;
import edu.sabanciuniv.sabanci05.model.dto.OrderRequest;
import edu.sabanciuniv.sabanci05.model.dto.OrderResponse;
import edu.sabanciuniv.sabanci05.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/orders/create")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }


}
