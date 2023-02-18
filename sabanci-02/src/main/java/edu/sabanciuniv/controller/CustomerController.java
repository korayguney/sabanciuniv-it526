package edu.sabanciuniv.controller;

import edu.sabanciuniv.CustomerService;
import edu.sabanciuniv.model.Customer;

import java.util.List;

public class CustomerController {

    public CustomerService service = new CustomerService();

    public List<Customer> findAllCustomers() {
        return service.findAll();
    }

    public Customer findCustomer(int id) {
        return service.find(id);
    }

    public void saveCustomer(Customer customer) {
        service.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        service.delete(customer);
    }


}
