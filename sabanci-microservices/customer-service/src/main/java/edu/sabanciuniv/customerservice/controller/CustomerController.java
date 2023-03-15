package edu.sabanciuniv.customerservice.controller;

import edu.sabanciuniv.customerservice.model.Customer;
import edu.sabanciuniv.customerservice.model.CustomerPremiumRequest;
import edu.sabanciuniv.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public long saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/customers/premium")
    public boolean registerCustomerAsPremium(@RequestBody CustomerPremiumRequest request){
        return customerService.registerCustomerAsPremium(request);
    }


}
