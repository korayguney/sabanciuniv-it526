package edu.sabanciuniv.sabanci05.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {
    private String bookName;
    private double price;
}
