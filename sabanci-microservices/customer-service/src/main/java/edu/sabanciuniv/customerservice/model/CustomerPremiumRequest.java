package edu.sabanciuniv.customerservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerPremiumRequest {
    private long customerId;
    private String cardHolder;
    private long cardNumber;
    private int cvv;
}
