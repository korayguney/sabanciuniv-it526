package edu.sabanciuniv.controller;

import edu.sabanciuniv.CustomerService;
import edu.sabanciuniv.model.Customer;

import java.util.List;

public class CustomerController {

    public CustomerService service = new CustomerService();

    public List<Customer> findAllCustomers() {
        return service.findAll();
    }



}
