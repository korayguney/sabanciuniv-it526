package edu.sabanci.sabanciexam.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionRequest {
    private String source;
    private String target;
    private double amount;
}
