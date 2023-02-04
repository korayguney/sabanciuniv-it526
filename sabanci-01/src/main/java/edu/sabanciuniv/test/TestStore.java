package edu.sabanciuniv.test;

import edu.sabanciuniv.model.ShoppingMall;
import edu.sabanciuniv.model.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class TestStore {
    public static void main(String[] args) {
        Store store1 = new Store("Nike", "2123345567", 345.56);
        Store store2 = new Store("Adidas", "2123345511", 560.45);
        Store store3 = new Store("Puma", "2163345599", 445.6);

        ShoppingMall shoppingMall1 = new ShoppingMall("Akasya AVM", "Kadıköy");
        ShoppingMall shoppingMall2 = new ShoppingMall("Cevahir AVM", "Mecidiyeköy");

        List<Store> storeList = new ArrayList<>();
        storeList.add(store1);
        storeList.add(store2);
        storeList.add(store3);

       // shoppingMall1.getStoreList().add(store3);
       // shoppingMall2.getStoreList().add(store1);
       // shoppingMall2.getStoreList().add(store2);

        store1.setShoppingMall(shoppingMall2);
        store2.setShoppingMall(shoppingMall2);
        store3.setShoppingMall(shoppingMall1);

        List<ShoppingMall> shoppingMallList = new ArrayList<>();
        shoppingMallList.add(shoppingMall1);
        shoppingMallList.add(shoppingMall2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
        EntityManager entityManager = emf.createEntityManager();

        saveShoppingMalls(shoppingMallList, entityManager);
        saveStores(storeList, entityManager);
        // findAllStores(entityManager);
        // findByStoreName(entityManager, store1.getStoreName());
        // findByStoreNameAndSquareMeter(entityManager, store2.getStoreName(), store2.getSquareMeter());
        // updateStorePhone(entityManager, store3, "5555555555");
        // deleteStore(entityManager, store2);
    }

    private static void saveShoppingMalls(List<ShoppingMall> shoppingMallList, EntityManager entityManager) {
        for (ShoppingMall shoppingMall : shoppingMallList) {
            entityManager.getTransaction().begin();
            entityManager.persist(shoppingMall);
            entityManager.getTransaction().commit();
        }
    }

    private static void deleteStore(EntityManager entityManager, Store store2) {
        entityManager.getTransaction().begin();

        // JPQL --> Java Persistence Query Language
        // HQL --> Hibernate Query Language
        Store foundStore = entityManager.createQuery("SELECT s FROM Store s WHERE s.storeName = :strName", Store.class)
                .setParameter("strName", store2.getStoreName())
                .getSingleResult();
        entityManager.remove(foundStore);

        entityManager.getTransaction().commit();
        System.out.println("Store deleted");
    }

    private static void updateStorePhone(EntityManager entityManager, Store store3, String newPhoneNumber) {
        entityManager.getTransaction().begin();

        Store foundStore = entityManager.createQuery("FROM Store s WHERE s.storeName = :strName", Store.class)
                .setParameter("strName", store3.getStoreName())
                .getSingleResult();
        foundStore.setStorePhone(newPhoneNumber);
        entityManager.merge(foundStore);

        entityManager.getTransaction().commit();
        System.out.println("Store phone updated to : " + newPhoneNumber);
    }

    private static void findByStoreName(EntityManager entityManager, String storeName) {
        // 01-alternative
        // TypedQuery<Store> storeJpql = entityManager.createQuery("FROM Store s WHERE s.storeName = :strName", Store.class);
        // storeJpql.setParameter("strName", storeName);
        // Store foundStore = storeJpql.getSingleResult();

        // 02-alternative
        Store foundStore = entityManager.createQuery("FROM Store s WHERE s.storeName = ?1", Store.class)
                .setParameter(1, storeName).getSingleResult();
        System.out.println(foundStore);
    }

    private static void findByStoreNameAndSquareMeter(EntityManager entityManager, String storeName, Double sqrMeters) {
        // 02-alternative
        //Store foundStore = entityManager.createQuery("FROM Store s WHERE s.storeName = ?1 AND s.squareMeter = ?2", Store.class)
        //        .setParameter(1, storeName)
        //        .setParameter(2, sqrMeters)
        //        .getSingleResult();
        Store foundStore = entityManager.createQuery("FROM Store s WHERE s.storeName = :strName AND s.squareMeter = :sqrMtr", Store.class)
                .setParameter("strName", storeName)
                .setParameter("sqrMtr", sqrMeters)
                .getSingleResult();
        System.out.println(foundStore);
    }

    private static void findAllStores(EntityManager entityManager) {
        TypedQuery storeJpql = entityManager.createQuery("FROM Store s", Store.class);
        List<Store> storeList = storeJpql.getResultList();

        for (Store store : storeList) {
            System.out.println(store);
        }
    }

    private static void saveStores(List<Store> storeList, EntityManager entityManager) {
        for (Store store : storeList) {
            entityManager.getTransaction().begin();
            entityManager.persist(store);
            entityManager.getTransaction().commit();
        }
    }
}
