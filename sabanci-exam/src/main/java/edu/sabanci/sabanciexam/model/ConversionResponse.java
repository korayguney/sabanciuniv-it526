package edu.sabanci.sabanciexam.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionResponse {
    private String target;
    private double amount;
    private String transactionId;
}
