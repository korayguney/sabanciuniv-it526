package edu.sabanciuniv.customerservice.service;

import edu.sabanciuniv.customerservice.exception.CustomerException;
import edu.sabanciuniv.customerservice.model.*;
import edu.sabanciuniv.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public long saveCustomer(Customer customer) {
        if (customer.getFirstname().length() < 2) {
            throw new IllegalArgumentException("Firstname length cannot be less then 2 characters!");
        }

        return customerRepository.save(CustomerEntity.builder()
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .build()).getId();
    }

    public boolean registerCustomerAsPremium(CustomerPremiumRequest request) {
        // check customer data from db
        CustomerEntity customerEntity = customerRepository.findById(request.getCustomerId())
                .orElseThrow(CustomerException::new);
        //.orElseThrow(() -> new CustomerDoesNotExistException());

        // map to CreditCardValidationRequest
        CreditCardValidationRequest validationRequest = CreditCardValidationRequest
                .builder()
                .customerId(request.getCustomerId())
                .cardNumber(request.getCardNumber())
                .build();

        // validate credit card number
        CreditCardValidationResponse response = restTemplate
                .postForObject("http://localhost:8081/creditcards/validate",
                        validationRequest, CreditCardValidationResponse.class);
        
        if(response.isValid()) {
            // retrieve payment
            log.info("Payment retrieved successfully!");
            
            // update CustomerEntity as premium
            customerEntity.setPremium(Boolean.TRUE);
            customerRepository.save(customerEntity);
        }

        // log result 
        if(response.isValid()) {
            log.info("Custtomer : {}'s membership is upgraded to premium!", customerEntity.getFirstname());
        } else {
            log.info("Customer with ID : {}'s membership is  NOT upgraded to premium!", customerEntity.getId());
        }

        // return result
        return response.isValid();

    }
}
