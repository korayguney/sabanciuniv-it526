package edu.sabanciuniv;

import edu.sabanciuniv.model.Customer;
import edu.sabanciuniv.repository.CrudRepository;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerService implements CrudRepository<Customer> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer find(int id) {
        return null;
    }

    @Override
    public void save(Customer object) {

    }

    @Override
    public void delete(Customer object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Customer object, int id) {

    }
}
