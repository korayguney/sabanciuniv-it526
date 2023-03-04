package edu.sabanciuniv.sabanci05.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {
    private int bookId;
    private String bookName;
    private double price;
    private String author;
}
