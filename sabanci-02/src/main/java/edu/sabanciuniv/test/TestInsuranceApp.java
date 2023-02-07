package edu.sabanciuniv.test;

import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.Month;

public class TestInsuranceApp {
    public static void main(String[] args) {
        saveTestData();
    }

    private static void saveTestData() {
        Customer customer1 = new Customer("Koray Guney", "Istanbul", 321562365123L, "111111111" );
        Customer customer2 = new Customer("Ali Veli", "Ankara", 32132143246L, "2222222222");
        Customer customer3 = new Customer("Ayse Simsek", "Edirne", 6452533241L, "3333333333");

        Vehicle car1 = new Car("Porsche Cayenne", 2020,  "34VG5677", "Red");
        Vehicle car2 = new Car("Toyota Corolla", 2017,  "08HG234", "Black");
        Vehicle moto1 = new Motorcycle("Suzuki",  2020, "65NN322", 120.0);
        Vehicle moto2 = new Motorcycle("Yamaha",  2017, "08TT122", 340.0);
        Vehicle moto3 = new Motorcycle("Harley Davidson", 2013,  "34VG111", 420.0);

        car1.setCustomer(customer1);
        car2.setCustomer(customer2);
        moto1.setCustomer(customer3);
        moto2.setCustomer(customer3);
        moto3.setCustomer(customer1);

        Accident accident1 = new Accident(LocalDate.of(2021, Month.AUGUST,12));
        Accident accident2 = new Accident(LocalDate.of(2020, Month.JUNE,24));
        Accident accident3 = new Accident(LocalDate.of(2019, Month.MARCH,4));

        car1.getAccidentList().add(accident1);
        car2.getAccidentList().add(accident1);
        moto1.getAccidentList().add(accident2);
        moto1.getAccidentList().add(accident3);
        moto3.getAccidentList().add(accident2);

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(car1);
            entityManager.persist(car2);
            entityManager.persist(moto1);
            entityManager.persist(moto2);
            entityManager.persist(moto3);

            entityManager.persist(customer1);
            entityManager.persist(customer2);
            entityManager.persist(customer3);

            entityManager.persist(accident1);
            entityManager.persist(accident2);
            entityManager.persist(accident3);
            entityManager.getTransaction().commit();
            System.out.println("All data persisted!...");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
