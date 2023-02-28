package edu.sabanciuniv.sabanci06.repository;

import edu.sabanciuniv.sabanci06.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
