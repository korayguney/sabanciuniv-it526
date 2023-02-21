package edu.sabanciuniv.service;

import edu.sabanciuniv.model.Customer;
import edu.sabanciuniv.repository.CrudRepository;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerService implements CrudRepository<Customer> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Customer> findAll() {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer find(int id) {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            System.out.println("Customer is saved!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(Customer customer) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            System.out.println("Customer is deleted!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Customer object, int id) {

    }
}
