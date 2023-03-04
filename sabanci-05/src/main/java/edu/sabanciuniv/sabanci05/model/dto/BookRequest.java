package edu.sabanciuniv.sabanci05.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookRequest {
    private String bookName;
    private double price;
    private String author;
    private String accessToken;
}
