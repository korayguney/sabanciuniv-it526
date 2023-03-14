package edu.sabanciuniv.customerservice.service;

import edu.sabanciuniv.customerservice.model.Customer;
import edu.sabanciuniv.customerservice.model.CustomerEntity;
import edu.sabanciuniv.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

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
}
