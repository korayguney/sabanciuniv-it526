package edu.sabanciuniv.customerservice.service;

import edu.sabanciuniv.customerservice.model.Customer;
import edu.sabanciuniv.customerservice.model.CustomerEntity;
import edu.sabanciuniv.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void saveCustomerTest() {
        // given
        Customer customer = Customer.builder().firstname("Ali").build();
        CustomerEntity customerEntity = CustomerEntity.builder().id(1L).build();
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customerEntity);

        // when
        long result = customerService.saveCustomer(customer);

        // then
        assertNotNull(result);
        assertEquals(customerEntity.getId(), 1L);
    }

    @Test
    void saveCustomerExceptionTest() {
        // given
        Customer customer = Customer.builder().firstname("A").build();

        // when
        Executable executable = () -> customerService.saveCustomer(customer);

        // then
        assertThrows(IllegalArgumentException.class, executable);
    }
}