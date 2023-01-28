package edu.sabanciuniv.test;

import edu.sabanciuniv.model.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    public static void main(String[] args) {
        Store store1 = new Store("Nike", "2123345567", 345.56);
        Store store2 = new Store("Adidas", "2123345511", 560.45);
        Store store3 = new Store("Puma", "2163345599", 445.6);

        List<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        for (Store store : storeList) {
            entityManager.getTransaction().begin();
            entityManager.persist(store);
            entityManager.getTransaction().commit();
        }
    }
}
