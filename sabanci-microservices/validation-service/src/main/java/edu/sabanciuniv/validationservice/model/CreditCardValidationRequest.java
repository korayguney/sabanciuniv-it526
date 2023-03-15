package edu.sabanciuniv.validationservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardValidationRequest {
    private long customerId;
    private long cardNumber;
}
